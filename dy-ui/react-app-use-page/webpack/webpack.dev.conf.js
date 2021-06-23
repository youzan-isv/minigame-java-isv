const utils = require("./utils");
const path = require("path");
const { CleanWebpackPlugin } = require("clean-webpack-plugin");
const merge = require("webpack-merge");
const baseWebpackConfig = require("./webpack.base.conf");

module.exports = merge(baseWebpackConfig, {
  mode: "development",
  output: {
    path: utils.devOutputDir(),
    filename: "[name].js",
  },
  plugins: [new CleanWebpackPlugin()],
});
