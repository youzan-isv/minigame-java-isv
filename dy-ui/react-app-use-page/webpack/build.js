"use strict";

const ora = require("ora");
const fs = require("fs-extra");
const path = require("path");
const chalk = require("chalk");
const webpack = require("webpack");
const md5File = require("md5-file/promise");
const glob = require("fast-glob");
const upload = require("youzanyun/lib");

const utils = require("./utils");
const webpackConfig = require("./webpack.prod.conf");
const { createEnv } = require("./utils");
const templateDir = path.join(__dirname, "template");
const env = createEnv(templateDir, { noCache: false, watch: false });

const spinner = ora("building for production...");
spinner.start();

async function run() {
  let appName = utils.getAppName();
  let outputDir = webpackConfig.output.path;

  const compiler = webpack(webpackConfig);
  const buildStats = await new Promise((resovle, reject) => {
    webpack(webpackConfig, (err, stats) => {
      spinner.stop();
      if (err) {
        reject(err);
      } else {
        resovle(stats);
      }
    });
  });
  console.log(
    `${buildStats.toString({
      colors: true,
      modules: false,
      children: false,
      chunks: false,
      chunkModules: false,
    })}\n\n`
  );
  if (buildStats.hasErrors()) {
    console.log(chalk.red("  Build failed with errors.\n"));
    process.exit(1);
  }
  console.log(chalk.cyan("  Build complete.\n"));
  const fileList = await glob(["**/*.js", "**/*.css"], {
    cwd: outputDir,
  });
  // 计算hash
  let jsFileUrlMap = {};
  let cssFileUrlMap = {};
  for (let fileName of fileList) {
    let extName = path.extname(fileName);
    let pageName = fileName.substring(0, fileName.length - extName.length);
    let hash = await md5File(path.resolve(outputDir, fileName));
    let url = `${appName}/react/${pageName}.${hash}`;
    let hashFileAbsolutePath = path.resolve(
      outputDir,
      `hash/${pageName}.${hash}${extName}`
    );
    await fs.copy(path.resolve(outputDir, fileName), hashFileAbsolutePath);
    let result = await upload([path.dirname(url), hashFileAbsolutePath], {
      hasHash: false,
    });
    if (extName == ".js") {
      jsFileUrlMap[pageName] = result[0];
    } else {
      cssFileUrlMap[pageName] = result[0];
    }
  }

  const template = env.render("prod_template.html", {
    jsUrl: JSON.stringify(jsFileUrlMap),
    cssUrl: JSON.stringify(cssFileUrlMap),
  });
  const outputPath = path.join(utils.prodOutputDir(), "index.html");

  await fs.writeFile(outputPath, template);
}

run();
