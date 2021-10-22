module.exports = {
  devServer: {
    port: 3000,
    overlay: false,
    watchOptions: {
      ignored: '**/node_modules',
    },
  },
  configureWebpack: {
    devtool: 'source-map',
  },
};
