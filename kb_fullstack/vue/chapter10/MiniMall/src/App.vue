<style scoped>
.main-container {
  background: #f0f0f0;
  padding: 4rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  margin: auto;
  text-align: center;
}
.layout {
  display: grid;
  grid-template-columns: 1fr 3fr;
}
.category {
  width: 100%;
  flex-shrink: 1;
}
</style>

<template>
  <header>
    <Header />
  </header>
  <div :class="layoutStyle">
    <div class="category">
      <router-view name="left" />
    </div>

    <div class="main-container">
      <!-- 좌측 필터 -->
      <main>
        <router-view />
        <!-- 기본 콘텐츠 -->
      </main>
    </div>
  </div>
</template>

<script setup>
import Header from './components/layout/Header.vue';
import { reactive, provide, computed } from 'vue';
import { useRoute } from 'vue-router';

const currentRoute = useRoute();

const state = reactive({
  cart: [],
});

const layoutStyle = computed(() => {
  return currentRoute.path === '/products' ? 'layout' : '';
});

const addToCart = (id) => {
  console.log('장바구니에 담기', id);
  const product = state.cart.find((item) => item.id === id);
  if (product) {
    product.count++;
  } else {
    state.cart.push({ id, count: 1 });
  }
};

provide('cart', state.cart);
provide('addToCart', addToCart);
</script>
