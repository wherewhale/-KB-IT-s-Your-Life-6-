<style scoped>
.subtitle {
  text-align: center;
}
</style>

<template>
  <section>
    <h2 class="subtitle">🧮 총 지출 : {{ formatNumber(totalAmount) }}</h2>
  </section>
</template>

<script setup>
const props = defineProps({
  totalAmount: { type: Number, required: true },
  formatNumber: { type: Function, required: true },
});
</script>
