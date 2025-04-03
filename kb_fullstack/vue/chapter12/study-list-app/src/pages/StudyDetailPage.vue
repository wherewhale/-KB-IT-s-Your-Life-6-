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
    <div class="d-flex gap-2 mt-4">
      <button class="btn btn-outline-danger" @click="onClickLike">❤️ 좋아요 누르기</button>
      <router-link class="btn btn-warning" :to="{ name: 'studyEdit', params: { id: study.id } }"
        >✏️ 수정하기</router-link
      >
      <router-link class="btn btn-success" :to="{ name: 'studyApply', params: { id: study.id } }"
        >✅ 신청하기</router-link
      >
    </div>

    <div class="day-badge">{{ convertDate(study.dueDate) }}</div>
    <br /><br />
    <router-link class="back-link" to="/studies"><- 목록으로</router-link>
    <div class="mt-5">
      <h2>📋 신청자 목록</h2>
      <ul class="list-group">
        <p v-if="apply && apply.length === 0" class="list-group-item">아직 신청자가 없습니다.</p>
        <li v-else v-for="(item, index) in apply" :key="index" class="list-group-item">
          {{ item.name }} ({{ item.contact }})
        </li>
      </ul>
    </div>
  </div>
</template>

<script setup>
import { getStudyDetail, putStudy, getStudyApply } from '@/api/study';
import { onMounted, ref, inject } from 'vue';
import { useRoute } from 'vue-router';

const { fetchStudyList } = inject('actions');

const study = ref(null);
const apply = ref(null);

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

const onClickLike = async () => {
  const updated = {
    ...study.value,
    likes: study.value.likes + 1,
  };
  study.value = updated;
  await putStudy(study.value.id, updated);
  fetchStudyList();
};

onMounted(async () => {
  study.value = await getStudyDetail(route.params.id);
  apply.value = await getStudyApply(route.params.id);
});
</script>
