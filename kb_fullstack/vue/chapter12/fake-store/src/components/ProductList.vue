<template>
  <div v-if="products.length > 0">
    <ProductItem
      v-for="product in products"
      :key="product.id"
      :product="product"
    />
  </div>
</template>

<script setup>
import ProductItem from './ProductItem.vue';

const props = defineProps({
  products: {
    type: Array,
  },
});
</script>
