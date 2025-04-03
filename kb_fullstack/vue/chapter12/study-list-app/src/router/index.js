import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../pages/StudiesPage.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      redirect: '/studies',
    },
    {
      path: '/studies',
      name: 'studies',
      component: () => import('../pages/StudiesPage.vue'),
    },
    {
      path: '/studies/:id',
      name: 'studyDetail',
      component: () => import('../pages/StudyDetailPage.vue'),
    },
    {
      path: '/studies/add',
      name: 'studyAdd',
      component: () => import('../pages/StudyAddPage.vue'),
    },
    {
      path: '/studies/:id/edit',
      name: 'studyEdit',
      component: () => import('../pages/StudyEdit.vue'),
    },
    {
      path: '/studies/:id/apply',
      name: 'studyApply',
      component: () => import('../pages/StudyApply.vue'),
    },
  ],
});

export default router;
