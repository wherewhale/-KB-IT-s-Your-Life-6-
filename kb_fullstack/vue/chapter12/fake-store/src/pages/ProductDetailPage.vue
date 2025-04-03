<style scoped>
img {
  width: 200px;
  height: 200px;
  object-fit: contain;
}

.link-style {
  text-decoration: none;
}
</style>

<template>
  <main v-if="product">
    <h2 class="fs-2 d-flex my-5 align-items-center gap-2">
      {{ product.title }}
    </h2>
    <div class="d-flex justify-content-between">
      <p>{{ product.category }}</p>
      <p>
        가격 : {{ product.price }} / 평점 : {{ product.rating.rate }} ({{
          product.rating.count
        }}명)
      </p>
    </div>
    <img :src="product.image" />
    <p>{{ product.description }}</p>
    <div class="d-flex justify-content-center gap-2">
      <router-link
        :to="{ name: product.category }"
        class="link-style btn btn-primary"
        >목록</router-link
      >
      <router-link
        class="link-style btn btn-primary"
        :to="{
          name: 'productEdit',
          query: { id: product.id, category: product.category },
        }"
        >수정</router-link
      >
      <router-link class="link-style btn btn-danger">삭제</router-link>
    </div>
  </main>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import { getProductDetail } from '@/api/product';
import { useRoute } from 'vue-router';

const product = ref(null);
const route = useRoute();

onMounted(async () => {
  product.value = await getProductDetail(route.params.id);
});
</script>
