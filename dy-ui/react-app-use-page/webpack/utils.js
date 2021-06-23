"use strict";
const path = require("path");
const ProjectDir = path.resolve(__dirname, "..");
const config = require("../config.json");
const nunjucks = require("nunjucks");

exports.createEnv = function(path, opts) {
  const autoescape = opts.autoescape === undefined ? true : opts.autoescape;
  const noCache = opts.noCache || false;
  const watch = opts.watch || false;
  const throwOnUndefined = opts.throwOnUndefined || false;
  // 从 path 中搜索 template 文件
  const env = new nunjucks.Environment(
    new nunjucks.FileSystemLoader(path, {
      noCache,
      watch,
    }),
    {
      autoescape,
      throwOnUndefined,
    }
  );
  if (opts.filters) {
    for (const [key, value] of Object.entries(opts.filters)) {
      env.addFilter(key, value);
    }
  }
  return env;
};

exports.getAppName = function() {
  return config.appName;
};
exports.getNodejsConfigDir = function() {
  return path.resolve(ProjectDir, config.configDir);
};
exports.devOutputDir = function() {
  return path.resolve(ProjectDir, config.devOutputDir);
};
exports.prodOutputDir = function() {
  return path.resolve(ProjectDir, config.prodOutputDir);
};
