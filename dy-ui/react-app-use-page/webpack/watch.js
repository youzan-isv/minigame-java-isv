"use strict";

const chalk = require("chalk");
const path = require("path");
const ora = require("ora");
const webpack = require("webpack");
const fs = require("fs-extra");
const utils = require("./utils");
const glob = require("fast-glob");
const express = require("express");
const https = require("https");
const http = require("http");
const spinner = ora("building for dev...");
spinner.start();

const webpackConfig = require("./webpack.dev.conf");
const { createEnv } = require("./utils");
const templateDir = path.join(__dirname, "template");
const env = createEnv(templateDir, { noCache: true, watch: true });
const port = process.env.PORT || 9000;

async function renderHTML() {
  const outputDir = webpackConfig.output.path;
  const fileList = await glob(["*.js", "*.css"], {
    cwd: outputDir,
  });
  const jsFileUrlMap = {};
  const cssFileUrlMap = {};
  for (let file of fileList) {
    const extName = path.extname(file);
    const pageName = file.substring(0, file.length - extName.length);
    if (extName == ".js") {
      jsFileUrlMap[pageName] = file;
    } else {
      cssFileUrlMap[pageName] = file;
    }
  }

  const template = env.render("dev_template.html", {
    jsUrl: JSON.stringify(jsFileUrlMap),
    cssUrl: JSON.stringify(cssFileUrlMap),
  });
  const outputPath = path.join(utils.devOutputDir(), "index.html");

  await fs.writeFile(outputPath, template);
}

function createServer() {
  const app = express();
  const options = {
    key: fs.readFileSync(path.resolve(__dirname, "./keys/server.key")),
    cert: fs.readFileSync(path.resolve(__dirname, "./keys/server.crt")),
  };
  app.use(express.static(utils.devOutputDir()));
  const httpsServer = https.createServer(options, app);
  const httpServer = http.createServer(app);

  httpsServer.listen(port, function () {
    console.log(
      chalk.blue(`\n\n监听端口${port}，https://localhost:${port}\n\n`)
    );
  });
  httpServer.listen(Number(port) + 1, function () {
    const newPort = Number(port) + 1;
    console.log(
      chalk.blue(`\n\n监听端口${newPort}，http://localhost:${newPort}\n\n`)
    );
  });
}

async function run() {
  const compiler = webpack(webpackConfig);
  const watching = compiler.watch({}, async function (err, stats) {
    await renderHTML();
    spinner.stop();

    if (err) {
      throw err;
    }

    if (stats.hasErrors()) {
      const info = stats.toJson();
      console.log(chalk.red("  Build failed with errors.\n", info.errors));
    }
  });
}

run();
createServer();
