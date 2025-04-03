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

  <form @submit.prevent="onSubmit">
    <label>
      스터디명
      <input type="text" :value="state.title" @change="onChangeTitle" />
    </label>
    <label>
      설명
      <textarea
        type="text"
        rows="4"
        :value="state.desc"
        @change="onChangeDescription"
      ></textarea>
    </label>
    <label>
      카테고리
      <select v-model="state.category">
        <option v-for="option in OPTIONS" :value="option.id">
          {{ option.name }}
        </option>
      </select>
    </label>
    <label>
      마감일
      <input type="date" :value="dueDate" @change="onChangeDueDate" />
    </label>
    <label>
      최대 인원 수
      <input type="number" v-model="state.max" />
    </label>
    <div class="btn-container">
      <button class="btn-submit" type="submit">등록하기</button>
      <button class="btn-cancel" type="button">취소</button>
    </div>
  </form>
</template>

<script setup>
import { reactive } from 'vue';
import { postStudy } from '@/api/study.js';
import { useRouter } from 'vue-router';

const router = useRouter();

const OPTIONS = [
  { id: 'front-end', name: '프론트엔드' },
  { id: 'back-end', name: '백엔드' },
  { id: 'AI', name: 'AI' },
];

const state = reactive({
  title: '',
  desc: '',
  category: 'front-end',
  dueDate: new Date().toISOString().split('T')[0],
  max: 0,
});

const onChangeTitle = (e) => {
  state.title = e.target.value;
};
const onChangeDescription = (e) => {
  state.desc = e.target.value;
};

const onChangeDueDate = (e) => {
  const newDate = new Date(e.target.value);
  if (newDate < new Date()) {
    alert('마감일은 오늘 이후로 설정해주세요.');
    return;
  } else {
    state.dueDate = new Date(e.target.value).toISOString().split('T')[0];
  }
};

const onSubmit = () => {
  if (state.title === '' || state.desc === '' || state.max <= 0) {
    alert('모든 항목은 필수 항목입니다.');
    return;
  }
  const inputData = {
    title: state.title,
    desc: state.desc,
    category: state.category,
    dueDate: state.dueDate,
    createdAt: new Date().toISOString().split('T')[0],
    max: state.max,
    likes: 0,
  };
  postStudy(inputData)
    .then(() => {
      alert('스터디 등록이 완료되었습니다.');
      router.push('/studies');
    })
    .catch((err) => {
      alert('스터디 등록에 실패했습니다.');
    });
};
</script>
