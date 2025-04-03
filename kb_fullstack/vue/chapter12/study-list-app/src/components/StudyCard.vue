<style scoped>
.card {
  border: 1px solid #4a4a4a;
  border-radius: 0.5rem;
  padding: 1rem;
  cursor: pointer;
}
h3 {
  margin-bottom: 1rem;
}
.day-badge {
  font-size: 0.75rem;
  border-radius: 0.5rem;
  background-color: darkgreen;
  width: fit-content;
  padding: 0.25rem 0.5rem;
  margin-top: 1rem;
  color: white;
}
</style>

<template>
  <li class="card" @click="onClickCard">
    <h3>
      <b>{{ props.study.title }}</b>
    </h3>
    <p>📌 카테고리: {{ props.study.category }}</p>
    <p>🗓️ 등록일: {{ props.study.createdAt }}</p>
    <p>📆 마감일: {{ props.study.dueDate }}</p>
    <p>❤️ 좋아요: {{ props.study.likes }}</p>
    <div class="day-badge">{{ convertDate(props.study.dueDate) }}</div>
  </li>
</template>

<script setup>
import { useRouter } from 'vue-router';

const props = defineProps({
  study: {
    type: Object,
    required: true,
  },
});
const router = useRouter();

const convertDate = (date) => {
  const today = new Date();
  const targetDate = new Date(date);
  // 밀리초 단위 차이 계산
  const diffTime = targetDate - today;

  if (Math.ceil(diffTime / (1000 * 60 * 60 * 24)) === 0) {
    return 'D-Day';
  }

  if (diffTime > 0) {
    return 'D-' + Math.ceil(diffTime / (1000 * 60 * 60 * 24));
  } else {
    return '모집 마감';
  }
};

const onClickCard = () => {
  //
  router.push(`studies/${props.study.id}`);
};
</script>
