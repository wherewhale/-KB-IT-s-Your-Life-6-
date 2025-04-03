<style scoped>
figure {
  width: 30px;
  height: 30px;
}

img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
li {
  list-style: none;
}
</style>

<template>
  <li>
    <router-link
      class="d-flex"
      :to="{ name: 'productDetail', params: { id: product.id } }"
    >
      <figure><img :src="product.image" /></figure>
      <p>{{ product.title }}</p>
    </router-link>
  </li>
</template>

<script setup>
const props = defineProps({
  product: {
    type: Object,
    required: true,
  },
});
</script>
