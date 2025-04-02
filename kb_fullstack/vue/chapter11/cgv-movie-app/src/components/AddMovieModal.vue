<style scoped>
.modal-container {
  color: black;
  position: absolute;
  background-color: white;
  max-width: 350px;
  width: 100%;
  padding: 2rem;
  border-radius: 0.5rem;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
input[type='text'] {
  width: 100%;
  margin-top: 0.5rem;
  padding: 0.25rem;
}

textarea {
  margin-top: 0.5rem;
}

.footer {
  display: flex;
  justify-content: space-between;
}
</style>

<template>
  <Teleport to="#modal">
    <div v-if="isOpen" class="modal-container">
      <div>
        <div class="header">
          <h3>🎥 영화 추가하기</h3>
        </div>
        <div class="body">
          <form>
            <input type="text" v-model="movieForm.title" placeholder="제목" />
            <input
              type="text"
              v-model.number="movieForm.year"
              placeholder="연도"
            />
            <input
              type="text"
              v-model="movieForm.director"
              placeholder="감독"
            />
            <textarea
              v-model="movieForm.description"
              placeholder="줄거리"
              rows="3"
              cols="35"
            ></textarea>
            <input
              type="text"
              v-model="movieForm.poster"
              placeholder="포스터 이미지 URL"
            />
          </form>
        </div>
        <div class="footer">
          <button @click="onSubmit">등록</button>
          <button @click="emit('on-close')">닫기</button>
        </div>
      </div>
    </div>
  </Teleport>
</template>

<script setup>
import { postMovie } from '@/api/movie';
import { reactive, ref } from 'vue';

const isLoading = ref(false);
const emit = defineEmits(['on-close']);

const props = defineProps({
  isOpen: {
    type: Boolean,
    default: false,
  },
});

const movieForm = reactive({
  title: null,
  year: null,
  director: null,
  description: null,
  poster: null,
});

const onSubmit = async () => {
  isLoading.value = true;
  if (movieForm.title === null) {
    alert('제목을 입력해주세요!');
  } else if (movieForm.year === null) {
    alert('연도를 입력해주세요!');
  } else if (movieForm.director === null) {
    alert('감독을 입력해주세요!');
  } else if (movieForm.description === null) {
    alert('줄거리를 입력해주세요.');
  } else if (movieForm.poster === null) {
    alert('포스터 url을 추가해주세요.');
  } else {
    await postMovie(movieForm);
    movieForm.title = null;
    movieForm.year = null;
    movieForm.director = null;
    movieForm.description = null;
    movieForm.poster = null;
    emit('on-close');
  }
  isLoading.value = false;
};
</script>
