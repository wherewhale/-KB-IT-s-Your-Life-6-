<style scoped>
.item-list {
  display: grid;
  grid-template-columns: repeat(4, 1fr);
  gap: 24px;
}
</style>

<template>
  <ul class="item-list">
    <ProductItem v-for="item in products" :key="item.id" :item="item" />
  </ul>
</template>

<script setup>
import productData from '@/data/products.json';
import ProductItem from './Item.vue';

const products = productData;
</script>
