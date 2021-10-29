const path = require('path');

module.exports = {
  publicPath: '',
  outputDir: '../backend/src/main/resources/static',
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
  chainWebpack: (config) => {
    config.output.filename('js/[name].js');
    config.plugin('html').tap((args) => {
      // eslint-disable-next-line no-param-reassign
      args[0].title = 'Community';
      return args;
    });
  },
  transpileDependencies: [
    'vuetify',
  ],
};
