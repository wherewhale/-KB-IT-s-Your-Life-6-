<style scoped>
.title-banner {
  background-color: #f0f0f0;
  height: 400px;
  overflow: hidden;
  position: relative;
  color: white;
}

img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.title-container {
  position: absolute;
  left: 20%;
  top: 0;
  height: 400px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  gap: 40px;
  z-index: 10;
}
</style>

<template>
  <div class="title-banner">
    <img
      src="https://cdn.jejusori.net/news/photo/201908/305449_306459_243.jpg"
      alt="banner image"
    />
    <div class="title-container">
      <h1>{{ title }}</h1>
      <p class="fs-4">{{ subtitle }}</p>
    </div>
  </div>
</template>

<script setup>
const props = defineProps({
  title: {
    type: String,
    default: 'Fake Store',
  },
  subtitle: {
    type: String,
    default: 'Vue3 연습 사이트',
  },
});
</script>
