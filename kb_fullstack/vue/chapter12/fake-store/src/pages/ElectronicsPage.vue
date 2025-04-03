<template>
  <main>
    <h2 class="fs-2 d-flex my-5 align-items-center gap-2">
      <i class="nav-link fa-solid fa-question"></i>가전 페이지
    </h2>
    <ProductList v-if="products" :products="products" />
  </main>
</template>

<script setup>
import { getProductList } from '@/api/product';
import ProductList from '@/components/ProductList.vue';
import { onMounted, ref } from 'vue';

const products = ref(null);

onMounted(async () => {
  products.value = await getProductList('electronics');
});
</script>
