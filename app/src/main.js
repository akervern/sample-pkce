import Vue from 'vue';
import CoreuiVue from '@coreui/vue';
import App from './App.vue';
import router from './router';
import icons from './assets/icons/icons';
import store from './store';

Vue.config.productionTip = false;
Vue.config.performance = true;
Vue.use(CoreuiVue);

new Vue({
  router,
  store,
  icons,
  render: (h) => h(App),
}).$mount('#app');
