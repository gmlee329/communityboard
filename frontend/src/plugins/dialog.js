const dialog = {};

dialog.install = function (Vue) {
  // eslint-disable-next-line no-param-reassign
  Vue.prototype.confirmDialog = function (title, text) {
    const res = this.$dialog.confirm({
      title,
      text,
      persistent: true,
      actions: {
        false: '취소',
        true: {
          color: 'red',
          text: '확인',
        },
      },
    });

    return res;
  };

  // eslint-disable-next-line no-param-reassign
  Vue.prototype.promptDialog = function (title, text, content) {
    const res = this.$dialog.prompt({
      title,
      text,
      value: content,
      persistent: true,
      actions: {
        false: '취소',
        true: {
          color: 'red',
          text: '확인',
        },
      },
    });

    return res;
  };
};

export default dialog;
