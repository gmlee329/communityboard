import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);

export const SET_SNACKBAR = 'SET_SNACKBAR';
export const SET_BOARD_LIST_OPTION = 'SET_BOARD_LIST_OPTION';
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
    },
  },
  mutations: {
    [SET_SNACKBAR](state, sb) {
      state.sb = sb;
    },
    [SET_BOARD_LIST_OPTION](state, blo) {
      state.blo = blo;
    },
  },
  actions: {
  },
  modules: {
  },
});
