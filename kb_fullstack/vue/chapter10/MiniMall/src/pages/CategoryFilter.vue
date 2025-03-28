<style>
ul {
  padding: 0;
}
</style>

<template>
  <h2>카테고리</h2>
  <ul>
    <li v-for="category in CATEGORIES" :key="category.id">
      {{ category.name }}
    </li>
  </ul>
</template>

<script setup>
const CATEGORIES = [
  { id: 1, name: '전체' },
  { id: 2, name: '리뷰' },
  { id: 3, name: '디지털' },
  { id: 4, name: '취미' },
];
</script>
