import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/HomePage.vue';
import About from '@/pages/AboutPage.vue';
import Members from '@/pages/MembersPage.vue';
import Videos from '@/pages/VideosPage.vue';
import MemberInfo from '@/pages/MemberInfoPage.vue';
const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', component: Home },
    { path: '/about', component: About },
    { path: '/members', component: Members },
    { path: '/members/:id', component: MemberInfo },
    { path: '/videos', component: Videos },
  ],
});
export default router;
