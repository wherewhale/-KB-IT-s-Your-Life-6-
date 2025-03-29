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
.tabs {
  display: flex;
  justify-content: center;
  margin-top: 20px;
  gap: 40px;
}

.tab-button {
  text-decoration: none;
  color: #333333;
  padding: 10px 20px;
}

.active-tab {
  font-weight: bold;
  background-color: #007bff;
  color: white;
  border-radius: 0.5rem;
}
</style>

<template>
  <h2>{{ product.name }}</h2>
  <div class="image-container">
    <img :src="product.image" alt="상품 이미지" />
  </div>
  <p>가격: {{ product.price.toLocaleString() }}원</p>
  <button class="add-button" @click="addToCart(product.id)">장바구니 담기</button>
  <div class="tabs">
    <router-link class="tab-button" :to="`/products/${product.id}`" exact-active-class="active-tab"
      >상세정보</router-link
    >
    <router-link class="tab-button" :to="`/products/${product.id}/review`" exact-active-class="active-tab"
      >리뷰</router-link
    >
  </div>
  <router-view name="detail" />
  <router-view name="review" />
</template>

<script setup>
import { useRoute } from 'vue-router';
import { inject } from 'vue';
import productData from '@/data/products.json';

const currentRoute = useRoute();

const product = productData.find((item) => item.id === parseInt(currentRoute.params.id));

const addToCart = inject('addToCart');
</script>
