<style scoped>
.category-item {
  display: flex;
  justify-content: space-between;
  gap: 2rem;
  padding: 1rem;
  border-radius: 12px;
  background-color: rgba(84, 84, 84, 0.65);
  color: white;
  margin-bottom: 1rem;
}
</style>

<template>
  <section>
    <h2 class="subtitle">📊 카테고리 별 지출 합계</h2>
    <li class="category-item" v-for="(category, idx) in categories" :key="idx">
      <span
        >{{ category.category }} :
        {{ category.amount.toLocaleString() }}원</span
      >
    </li>
  </section>
</template>

<script setup>
import { defineProps } from 'vue';

const props = defineProps({
  categories: {
    type: Array,
    required: true,
  },
});
</script>
