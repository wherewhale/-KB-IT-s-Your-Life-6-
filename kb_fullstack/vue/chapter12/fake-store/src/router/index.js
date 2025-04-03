import { createRouter, createWebHistory } from 'vue-router';
import HomeView from '@/pages/HomePage.vue';

// [brand] / home HomePage
// 가전 /electronics electronics ElectronicsPage
// 주얼리 /jewelery jewelery JeweleryPage
// 남성의류 /mensclothing mensclothing MensClothingPage
// 여성의류 /womenclothing womenclothing WomensClothingPage

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/electronics',
      name: 'electronics',
      component: () => import('../pages/ElectronicsPage.vue'),
    },
    {
      path: '/jewelery',
      name: 'jewelery',
      component: () => import('../pages/JeweleryPage.vue'),
    },
    {
      path: '/mensclothing',
      name: "men's clothing",
      component: () => import('../pages/MensClothingPage.vue'),
    },
    {
      path: '/womensclothing',
      name: "women's clothing",
      component: () => import('../pages/WomensClothingPage.vue'),
    },
    {
      path: '/product/:id',
      name: 'productDetail',
      component: () => import('../pages/ProductDetailPage.vue'),
    },
    {
      path: '/product/write',
      name: 'productWrite',
      component: () => import('../pages/ProductWritePage.vue'),
    },
    {
      path: '/product/edit',
      name: 'productEdit',
      component: () => import('../pages/ProductEditPage.vue'),
    },
  ],
});

export default router;
