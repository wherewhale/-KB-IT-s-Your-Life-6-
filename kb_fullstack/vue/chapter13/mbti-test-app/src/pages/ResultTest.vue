<style scoped>
p {
  margin: 0;
  padding: 0;
}
</style>

<template>
  <div class="card p-5 mt-5">
    <h2 class="text-primary fw-bold text-center text-success">
      저장된 MBTI 궁합 결과
    </h2>
    <ul class="list-group">
      <li
        class="list-group-item d-flex justify-content-between align-items-center text-start"
        style="list-style: none"
        v-if="results.length > 0"
        v-for="(result, index) in results"
        :key="index + result.id"
      >
        <div>
          <p class="fs-4 fw-bold">
            {{ result.myMBTI }} ❤️ {{ result.friendMBTI }}
          </p>
          <p>
            {{ result.result }}
          </p>
          <p>궁합률 : {{ result.compatibility }}</p>
        </div>
        <button
          class="btn btn-outline-danger"
          @click="onClickDeleteResult(result.id)"
        >
          삭제
        </button>
      </li>
      <li v-else class="list-group-item">
        <p class="text-center text-secondary fw-bold fs-5">
          저장된 결과가 없습니다.
        </p>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { getMatchResultList, deleteMatchResult } from '@/api/match';
import { onMounted, ref } from 'vue';

const results = ref([]);

const onClickDeleteResult = async (id) => {
  if (confirm('정말 삭제하시겠습니까?')) {
    await deleteMatchResult(id);
    results.value = await getMatchResultList();
  }
};

onMounted(async () => {
  results.value = await getMatchResultList();
});
</script>
