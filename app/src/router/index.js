import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '@/views/Home.vue';
import ApiDemo from '@/views/ApiDemo.vue';
import Auth from '@okta/okta-vue';
import config from '@/config';

// Add Okta-Auth
Vue.use(Auth, config.okta);

Vue.use(VueRouter);

// Define Routes
const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue'),
  },
  {
    path: '/api',
    name: 'ApiDemo',
    component: ApiDemo,
  },
  {
    path: '/implicit/callback',
    component: Auth.handleCallback(),
    meta: {
      bypassAuth: true,
    },
  },
];

const router = new VueRouter({
  mode: 'history',
  routes,
});

// Set Navigation Guard global: https://router.vuejs.org/en/advanced/navigation-guards.html
// router.beforeEach(Vue.prototype.$auth.authRedirectGuard());
// Enforce every route to be authenticated, except those with meta.byPassAuth
router.beforeEach(async (to, from, next) => {
  const auth = Vue.prototype.$auth;
  if (!to.matched.some((record) => record.meta.bypassAuth) && !(await auth.isAuthenticated())) {
    auth.login(to.path);
  } else {
    next();
  }
});

export default router;
