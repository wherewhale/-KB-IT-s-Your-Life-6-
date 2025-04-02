<style scoped>
.link-container {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(240px, 1fr));
  gap: 1rem;
  padding: 2rem;
  width: 100%;
  flex-wrap: wrap;
}
.detail-link {
  color: gold;
  text-decoration: none;
}

.detail-link:hover {
  color: white;
  display: block;
}

li {
  list-style: none;
}
</style>

<template>
  <ul class="link-container">
    <!-- <p v-if="selectedMovie">{{ selectedMovie.title }}</p> -->
    <EditMovieModal v-if="showModal" :isOpen="showModal" :movie="selectedMovie" @on-close="onModalClose" />
    <li v-for="movie in movies" :key="movie.id">
      <MovieCard :movie="movie" @edit-requested="selectedMovie = $event" @delete-requested="handleDelete" />
    </li>
  </ul>
</template>

<script setup>
import { inject, ref, watch } from 'vue';
import MovieCard from './MovieCard.vue';
import EditMovieModal from './EditMovieModal.vue';
import { deleteMovie, getMovieList } from '@/api/movie';

const showModal = ref(false);
const selectedMovie = ref(null);
const movies = inject('movies');

watch(selectedMovie, (newMovie) => {
  if (newMovie) showModal.value = true;
});

const onModalClose = async () => {
  showModal.value = false;
  movies.value = await getMovieList();
};

const handleDelete = async (id) => {
  if (confirm('정말 삭제하시겠습니까?')) {
    await deleteMovie(id);
    alert('삭제 완료!');
    movies.value = await getMovieList();
  }
};
</script>
