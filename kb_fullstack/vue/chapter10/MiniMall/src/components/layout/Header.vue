<style scoped>
.header-navigation {
  height: 60px;
  display: flex;
  width: 100%;
  justify-content: center;
  align-items: center;
  gap: 2rem;
  background-color: white;
  box-shadow: 0px 2px 5px rgba(0, 0, 0, 0.15);
  position: relative;
  z-index: 1;
}
.nav-item {
  font-size: 1.2rem;
  text-decoration: none;
  color: black;
}

.nav-item:hover {
  color: #007bff;
}

.nav-item-active {
  font-weight: bold;
  color: #007bff;
}
</style>

<template>
  <nav class="header-navigation">
    <RouterLink
      v-for="item in MENU"
      :key="item.name"
      :to="item.path"
      class="nav-item"
      :class="{ 'nav-item-active': activePath === item.path }"
    >
      {{ item.label }}</RouterLink
    >
  </nav>
</template>

<script setup>
import { RouterLink, useRoute } from 'vue-router';
import { ref, watch } from 'vue';

const route = useRoute();
const activePath = ref(route.path);

watch(
  () => route.path,
  (newPath) => {
    activePath.value = newPath;
  }
);

const MENU = [
  { name: 'Home', path: '/', label: '홈' },
  { name: 'Products', path: '/products', label: '상품목록' },
  { name: 'Cart', path: '/cart', label: '장바구니' },
];
</script>
