<style scoped>
.link-container {
  display: flex;
  flex-direction: column;
  gap: 1rem;
  padding: 2rem;
}
.detail-link {
  color: gold;
  text-decoration: none;
}

.detail-link:hover {
  color: white;
  display: block;
}
</style>

<template>
  <ul class="link-container">
    <li v-for="movie in movies" :key="movie.id">
      <router-link
        class="detail-link"
        :to="{ name: 'movieDetail', params: { id: movie.id } }"
      >
        🎬 {{ movie.title }} - {{ movie.director }}
      </router-link>
    </li>
  </ul>
</template>

<script setup>
import { inject } from 'vue';

const movies = inject('movies');
</script>
