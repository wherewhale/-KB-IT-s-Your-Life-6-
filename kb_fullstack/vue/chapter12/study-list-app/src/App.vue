<style scoped>
.container {
  padding: 2rem;
  margin: auto;
}
</style>

<template>
  <header></header>

  <div class="container">
    <RouterView />
  </div>
</template>

<script setup>
import { onMounted, provide, reactive, computed, ref } from 'vue';
import { RouterLink, RouterView } from 'vue-router';
import { getStudyList } from './api/study';

const isRecruiting = ref(false);
const sorting = ref('created');
const states = reactive({ studies: null });

const onChangeFilter = () => {
  const today = new Date(); // 현재 날짜 가져오기
  const formattedToday = today.toISOString().split('T')[0]; // 'yyyy-mm-dd' 형식 변환

  states.studies = states.studies.filter((study) => {
    return study.dueDate >= formattedToday; // 오늘 이후 날짜만 남기기
  });
};

const onChangeSort = async (newSort) => {
  sorting.value = newSort;

  if (newSort === 'due') {
    states.studies = states.studies.sort((a, b) => new Date(a.dueDate) - new Date(b.dueDate));
  } else if (newSort === 'created') {
    states.studies = states.studies.sort((a, b) => new Date(b.createdAt) - new Date(a.createdAt));
  } else {
    states.studies = await getStudyList(sorting.value);
  }
};

const fetchStudyList = async () => {
  states.studies = await getStudyList();
};

// 필터링 조건 추가
provide(
  'studies',
  computed(() => states.studies)
);
provide(
  'isRecruiting',
  computed(() => isRecruiting.value)
); // ✅ 반응형 유지
provide(
  'sorting',
  computed(() => sorting.value)
); // ✅ 반응형 유지
provide('actions', {
  onChangeFilter,
  onChangeSort,
  fetchStudyList,
}); // ✅ 반응형 유지
// isRecruiting 변화에 따라 새로운 studies 반환

onMounted(async () => {
  states.studies = await getStudyList();
  onChangeSort('created');
});
</script>
