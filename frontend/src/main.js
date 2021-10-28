import Vue from 'vue';
import VuetifyDialog from 'vuetify-dialog';
import App from '@/App.vue';
import router from '@/router';
import store from '@/store';
import vuetify from '@/plugins/vuetify';
import 'vuetify-dialog/dist/vuetify-dialog.css';
import page from '@/plugins/page';
import dialog from '@/plugins/dialog';
import Button from '@/components/common/Button.vue';

Vue.config.productionTip = false;

Vue.component('Button', Button);

Vue.use(VuetifyDialog, {
  context: {
    vuetify,
  },
});
Vue.use(page);
Vue.use(dialog);

new Vue({
  router,
  store,
  vuetify,
  render: (h) => h(App),
}).$mount('#app');
