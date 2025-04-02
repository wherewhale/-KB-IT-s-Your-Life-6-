<style scoped>
main {
  max-width: 768px;
  padding: 2rem;
}
</style>

<template>
  <header></header>
  <main>
    <h1>🎥 지브리 영화 리스트</h1>
    <button class="add-movie-button" @click="onModalOpen">
      🎬 영화 추가하기
    </button>
    <AddMovieModal :isOpen="showModal" @on-close="onModalClose" />
    <RouterView />
  </main>
</template>

<script setup>
import { RouterView } from 'vue-router';
import { onMounted, provide, ref } from 'vue';
import { getMovieList } from './api/movie.js';
import AddMovieModal from './components/AddMovieModal.vue';

const movies = ref(null);
const showModal = ref(false);

provide('movies', movies);

const onModalOpen = () => {
  showModal.value = true;
};
const onModalClose = async () => {
  showModal.value = false;
  movies.value = await getMovieList();
};

onMounted(async () => {
  movies.value = await getMovieList();
});
</script>
