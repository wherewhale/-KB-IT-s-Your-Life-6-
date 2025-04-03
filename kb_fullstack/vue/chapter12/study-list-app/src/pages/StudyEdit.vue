<style scoped>
input,
textarea {
  width: 100%;
  padding: 0.5rem;
}

form {
  display: flex;
  flex-direction: column;
  gap: 2rem;
  margin-top: 2rem;
}

button {
  border-radius: 0.25rem;
  padding: 0.5rem 1rem;
  border: none;
  width: fit-content;
}

.btn-submit {
  background-color: dodgerblue;
  color: white;
}

.btn-cancel {
  background-color: white;
  border: 1px solid gray;
  color: gray;
}

.btn-container {
  display: flex;
  gap: 2rem;
}
</style>

<template>
  <h1>✏ 스터디 등록</h1>

  <form v-if="study !== null" @submit.prevent="onSubmit">
    <label>
      스터디명
      <input type="text" v-model="study.title" />
    </label>
    <label>
      설명
      <textarea type="text" rows="4" v-model="study.desc"></textarea>
    </label>
    <label>
      카테고리
      <select v-model="study.category">
        <option v-for="option in OPTIONS" :value="option.id">
          {{ option.name }}
        </option>
      </select>
    </label>
    <label>
      마감일
      <input type="date" v-model="study.dueDate" />
    </label>
    <label>
      최대 인원 수
      <input type="number" v-model="study.max" />
    </label>
    <div class="btn-container">
      <button class="btn-submit" type="submit">저장하기</button>
      <button class="btn-cancel" type="button">취소</button>
    </div>
  </form>
</template>

<script setup>
import { onMounted, ref, inject } from 'vue';
import { putStudy } from '@/api/study.js';
import { useRouter, useRoute } from 'vue-router';
import { getStudyDetail } from '@/api/study.js';

const router = useRouter();
const route = useRoute();

const { fetchStudyList } = inject('actions');

const OPTIONS = [
  { id: 'front-end', name: '프론트엔드' },
  { id: 'back-end', name: '백엔드' },
  { id: 'AI', name: 'AI' },
];

const study = ref(null);

const onSubmit = async () => {
  if (study.value.title === '' || study.value.desc === '' || study.value.max <= 0) {
    alert('모든 항목은 필수 항목입니다.');
    return;
  }

  const newDate = new Date(study.value.dueDate);
  if (newDate < new Date()) {
    alert('마감일은 오늘 이후로 설정해주세요.');
    return;
  }

  study.value.dueDate = new Date(study.value.dueDate).toISOString().split('T')[0];
  await putStudy(route.params.id, { ...study.value });
  await fetchStudyList();
  alert('수정 완료!');

  router.push(`/studies/${route.params.id}`);
};

onMounted(async () => {
  study.value = await getStudyDetail(route.params.id);
});
</script>
