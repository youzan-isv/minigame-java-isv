const utils = require("./utils");
const path = require("path");
const merge = require("webpack-merge");
const { CleanWebpackPlugin } = require("clean-webpack-plugin");
const baseWebpackConfig = require("./webpack.base.conf");
const OptimizeCssAssetsPlugin = require("optimize-css-assets-webpack-plugin");
const webpackConfig = merge(baseWebpackConfig, {
  mode: "production",
  output: {
    path: utils.prodOutputDir(),
    filename: "[name].js",
  },
  plugins: [new OptimizeCssAssetsPlugin(), new CleanWebpackPlugin()],
});

module.exports = webpackConfig;
