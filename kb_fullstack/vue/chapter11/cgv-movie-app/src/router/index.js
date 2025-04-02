import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      redirect: '/movies',
    },
    {
      path: '/movies',
      name: 'movies',
      component: () => import('../pages/MoviePage.vue'),
    },
    {
      path: '/movies/:id',
      name: 'movieDetail',
      component: () => import('../pages/MovieDetailPage.vue'),
    },
  ],
});

export default router;
