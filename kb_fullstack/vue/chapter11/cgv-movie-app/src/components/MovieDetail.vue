<style scoped>
.movie-title {
  margin-top: 2rem;
}
.poster-container {
  width: 350px;
  height: auto;
  margin-top: 2rem;
}
img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  object-position: center;
}
</style>

<template>
  <p v-if="isLoading">로딩 중... (스피너 모시깽)</p>
  <div v-else>
    <h2 class="movie-title">🎥{{ movie.title }} ({{ movie.year }})</h2>
    <p>감독 : {{ movie.director }}</p>
    <p>줄거리 : {{ movie.description }}</p>
    <figure class="poster-container" v-if="movie?.poster">
      <img :src="movie.poster" alt="영화 포스터" />
    </figure>
    <p v-else>이미지 없음</p>
  </div>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import { getMovieDetail } from '@/api/movie';
import { useRoute } from 'vue-router';

const route = useRoute();
const isLoading = ref(true); // 초기 상태를 true로 설정
const movie = ref(null); // 데이터를 받을 때까지 null로 설정

onMounted(async () => {
  try {
    const movieData = await getMovieDetail(route.params.id);
    movie.value = movieData;
  } catch (error) {
    console.error('영화 정보를 불러오는 중 오류 발생:', error);
  } finally {
    isLoading.value = false; // 요청 완료 후 로딩 상태 변경
    console.log(movie.value.poster);
  }
});
</script>
