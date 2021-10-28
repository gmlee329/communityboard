import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Main',
    redirect: '/home',
  },
  {
    path: '*',
    name: '404',
    component: () => import('@/views/error/404.vue'),
  },
  {
    path: '/home',
    name: 'Home',
    component: Home,
  },
  {
    path: '/board',
    name: 'BoardList',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/board/ListView.vue'),
  },
  {
    path: '/board/write',
    name: 'BoardWrite',
    component: () => import('@/views/board/WriteView.vue'),
  },
  {
    path: '/board/:docNo',
    name: 'BoardDetail',
    component: () => import('@/views/board/DetailView.vue'),
  },
  {
    path: '/board/:docNo/edit',
    name: 'BoardEdit',
    component: () => import('@/views/board/EditView.vue'),
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
