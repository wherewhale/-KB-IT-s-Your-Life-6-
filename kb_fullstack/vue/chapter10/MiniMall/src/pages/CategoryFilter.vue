<style scoped>
.menu {
  padding: 0 2rem;
}

.menu h2 {
  font-size: 2rem;
  margin-bottom: 1rem;
}

ul {
  padding: 0;
}

.menu li {
  font-size: 1.5rem;
}
</style>

<template>
  <aside class="menu">
    <h2>카테고리</h2>
    <ul>
      <li v-for="category in CATEGORIES" :key="category.id">
        {{ category.name }}
      </li>
    </ul>
  </aside>
</template>

<script setup>
const CATEGORIES = [
  { id: 1, name: '전체' },
  { id: 2, name: '리뷰' },
  { id: 3, name: '디지털' },
  { id: 4, name: '취미' },
];
</script>
