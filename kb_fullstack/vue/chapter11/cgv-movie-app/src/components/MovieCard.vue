<style scoped>
.card {
  background-color: #2a2a2a;
  border-radius: 0.5rem;
  padding: 1rem;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 1rem;
}
.poster {
  width: 100%;
  height: 300px;
  background-size: cover;
  background-position: center;
  border-radius: 0.5rem;
}

.button-container {
  display: flex;
  justify-content: center;
  gap: 1rem;
  align-items: center;
}

button {
  margin-top: 0;
}

.detail-link {
  text-decoration: none;
}
</style>

<template>
  <div class="card">
    <div class="poster" :style="{ backgroundImage: `url(${props.movie.poster})` }"></div>
    <h3>{{ props.movie.title }} ({{ props.movie.year }})</h3>
    <p><b>감독: </b>{{ props.movie.director }}</p>
    <div class="button-container">
      <button @click="onClickModify">✏️수정</button>
      <button @click="onClickDelete">🗑️삭제</button>
    </div>
    <RouterLink class="detail-link" :to="{ name: 'movieDetail', params: { id: props.movie.id } }"
      >🔎 자세히 보기</RouterLink
    >
  </div>
</template>

<script setup>
import { RouterLink } from 'vue-router';

const emit = defineEmits(['edit-requested', 'delete-requested']);
const props = defineProps({
  movie: Object,
});

const onClickModify = () => {
  emit('edit-requested', props.movie);
};

const onClickDelete = () => {
  emit('delete-requested', props.movie.id);
};
</script>
