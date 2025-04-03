<style scoped>
.info-container {
  border-radius: 1rem;
  overflow: hidden;
  border: 1px solid gray;
}
p {
  padding: 0.5rem;
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

.back-link {
  text-decoration: none;
  padding: 0.5rem 1rem;
  border: 1px solid gray;
  border-radius: 0.5rem;
  color: gray;
}
</style>

<template>
  <div v-if="study !== null">
    <h1>{{ study.title }}</h1>
    <p>{{ study.desc }}</p>
    <div class="info-container">
      <p>📆 마감일: {{ study.dueDate }}</p>
      <hr />
      <p>🗓️ 등록일: {{ study.createdAt }}</p>
      <hr />
      <p>📌 카테고리: {{ study.category }}</p>
      <hr />
      <p>🧑‍🧑‍🧒 최대 인원: {{ study.max }}</p>
      <hr />
      <p>❤️ 좋아요: {{ study.likes }}</p>
    </div>
    <div class="day-badge">{{ convertDate(study.dueDate) }}</div>
    <br /><br />
    <router-link class="back-link" to="/studies"><- 목록으로</router-link>
  </div>
</template>

<script setup>
import { getStudyDetail } from '@/api/study';
import { onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';

const study = ref(null);

const route = useRoute();

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

onMounted(async () => {
  study.value = await getStudyDetail(route.params.id);
  console.log(study.value);
});
</script>
