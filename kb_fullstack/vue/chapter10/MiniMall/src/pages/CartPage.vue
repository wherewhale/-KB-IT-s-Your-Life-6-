<style scoped>
.product-item {
  min-width: 400px;
  display: flex;
  gap: 24px;
  border-bottom: 1px solid gray;
  padding: 12px;
}
.image-container {
  width: 180px;
  height: 180px;
  border-radius: 8px;
  overflow: hidden;
  display: flex;
  justify-content: center;
  align-items: center;
}
img {
  width: 100%;
  height: 100%;
  object-fit: contain;
}

.product-name {
  font-size: 1.2rem;
  font-weight: bold;
}
.product-info {
  font-size: 1rem;
  color: gray;
}
.total-amount {
  font-size: 1.5rem;
  font-weight: bold;
  margin-top: 16px;
}
</style>

<template>
  <h2>🛒장바구니</h2>
  <ul>
    <li class="product-item" v-for="product in cart" :key="product.id">
      <div class="image-container">
        <img :src="product.image" alt="상품 이미지" />
      </div>
      <div>
        <p class="product-name">{{ product.name }}</p>
        <p class="product-info">{{ product.price.toLocaleString() }}원</p>
        <p class="product-info">담은 수량: {{ product.count }}</p>
      </div>
    </li>
  </ul>
  <p class="total-amount">총합: {{ totalAmount.toLocaleString() }}원</p>
</template>

<script setup>
import { inject } from 'vue';

import productData from '@/data/products.json';
import { computed } from 'vue';

const cartData = inject('cart');

const cart = computed(() => {
  return cartData.map((item) => {
    const product = productData.find((product) => product.id === item.id);
    return {
      ...product,
      count: item.count,
    };
  });
});

const totalAmount = computed(() => {
  return cart.value.reduce((acc, item) => {
    return acc + item.price * item.count;
  }, 0);
});
</script>
