<style scoped>
.image-container {
  width: 240px;
  height: 240px;
  border-radius: 8px;
  overflow: hidden;
  display: flex;
  justify-content: center;
  align-items: center;
  margin: auto;
}
img {
  width: 100%;
  height: 100%;
  object-fit: contain;
}
.add-button {
  padding: 10px 20px;
  background-color: #007bff;
  color: white;
  border: 0;
  border-radius: 8px;
  cursor: pointer;
}
.add-button:hover {
  background-color: #0056b3;
}
</style>

<template>
  <h2>{{ product.name }}</h2>
  <div class="image-container">
    <img :src="product.image" alt="상품 이미지" />
  </div>
  <p>가격: {{ product.price.toLocaleString() }}원</p>
  <button class="add-button" @click="addToCart(product.id)">
    장바구니 담기
  </button>
</template>

<script setup>
import { useRoute } from 'vue-router';
import { inject } from 'vue';
import productData from '@/data/products.json';

const currentRoute = useRoute();

const product = productData.find(
  (item) => item.id === parseInt(currentRoute.params.id)
);

const addToCart = inject('addToCart');
</script>
