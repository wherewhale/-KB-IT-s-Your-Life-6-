import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '../pages/HomePage.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/products',
      name: 'products',
      components: {
        default: () => import('../pages/Products.vue'),
        left: () => import('../pages/CategoryFilter.vue'),
      },
    },
    {
      path: '/products/:id',
      name: 'products/id',
      component: () => import('../pages/ProductDetailPage.vue'),
    },
    {
      path: '/cart',
      name: 'cart',
      component: () => import('../pages/CartPage.vue'),
    },
  ],
});

export default router;
