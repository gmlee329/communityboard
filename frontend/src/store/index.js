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
  },
  mutations: {
    [SET_SNACKBAR](state, sb) {
      state.sb = sb;
    },
  },
  actions: {
  },
  modules: {
  },
});
