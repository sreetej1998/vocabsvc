const merge = require('webpack-merge');
const path = require('path');
const BaseConfig = require('./webpack.config.base');

module.exports = merge(BaseConfig, {
  mode: 'development',
  devServer: {
    contentBase: path.join(__dirname, './dist'),
    historyApiFallback: true,
    port: 5500,
  },
  devtool: 'source-map',
  resolve: {
    extensions: ['.js', '.jsx'],
  },
});
