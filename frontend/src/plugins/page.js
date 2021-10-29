const page = {};

page.install = function (Vue) {
  // eslint-disable-next-line no-param-reassign
  Vue.prototype.movePage = function (url) {
    if (this.$route.path !== url) {
      this.$router.push(url);
    }
  };
  // eslint-disable-next-line no-param-reassign
  Vue.prototype.prevPage = function () {
    // eslint-disable-next-line no-unused-expressions
    window.history.length > 1 ? this.$router.go(-1) : this.$router.push('/');
  };
  // eslint-disable-next-line no-param-reassign
  Vue.prototype.refresh = function () {
    this.$router.go(this.$router.currentRoute);
  };
};

export default page;
