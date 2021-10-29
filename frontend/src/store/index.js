import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    sb: {
      show: false,
      msg: '',
      color: '',
    },
    blo: {
      options: {
        multiSort: true,
        sortBy: [],
        sortDesc: [],
        page: 1,
        itemsPerPage: 5,
      },
      schType: '',
      schVal: '',
      isFromDetail: false,
    },
  },
  mutations: {
    setSnackbar(state, sb) {
      state.sb = sb;
    },
    setBoardListOptions(state, blo) {
      state.blo = blo;
    },
  },
  actions: {
  },
  getters: {

  },
  modules: {
  },
});
