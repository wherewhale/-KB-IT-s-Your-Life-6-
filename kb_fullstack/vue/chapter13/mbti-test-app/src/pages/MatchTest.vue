<template>
  <div class="card p-5 mt-5">
    <h2 class="text-primary fw-bold text-center">MBTI 궁합 테스트</h2>

    <label class="w-100 text-start fw-bold d-flex gap-2 flex-column">
      나의 MBTI
      <select
        class="w-100 form-select"
        :value="myMBTI"
        @change="updateMyMBTI($event.target.value)"
      >
        <option value="" disabled>선택하세요</option>
        <option v-for="mbti in MBTI" :key="mbti" :value="mbti">
          {{ mbti }}
        </option>
      </select>
    </label>

    <label class="w-100 text-start fw-bold d-flex gap-2 flex-column mt-4">
      친구의 MBTI
      <select
        class="w-100 form-select"
        :value="opponentMBTI"
        @change="updateOpponentMBTI($event.target.value)"
      >
        <option value="" disabled>선택하세요</option>
        <option v-for="mbti in MBTI" :key="mbti" :value="mbti">
          {{ mbti }}
        </option>
      </select>
    </label>

    <button class="btn btn-primary mt-4 w-100" @click="onClickCalculate">
      궁합 계산
    </button>

    <div
      class="alert alert-success text-center text-dark mt-4"
      v-if="isSubmitted"
    >
      <p class="fw-bold fs-3">{{ myMBTI }} ❤️ {{ opponentMBTI }}</p>
      <p class="text-center" v-if="matchResult?.length === 1">
        {{ matchResult[0].result }}<br />
        <b>궁합률: {{ matchResult[0].compatibility }}</b>
      </p>
      <p v-else>
        데이터 없음 : 이 조합은 아직 등록되지 않았어요!<br />
        <b>궁합률: ??? %</b>
      </p>
    </div>
    <button
      class="mt-4 btn btn-success w-100"
      :class="{ disabled: isLoading }"
      v-if="matchResult?.length > 0"
      @click="onClickSaveResult"
    >
      결과 저장
    </button>
    <div class="alert alert-info text-center mt-4" v-if="!isLoading && isSaved">
      저장 완료! 결과 목록으로 이동 중...
    </div>
  </div>
</template>

<script setup>
import { computed, ref } from 'vue';
import { useMatchStore } from '@/stores/matchStore';

const MBTI = [
  'ISTJ',
  'ISFJ',
  'INFJ',
  'INTJ',
  'ISTP',
  'ISFP',
  'INFP',
  'INTP',
  'ESTP',
  'ESFP',
  'ENFP',
  'ENTP',
  'ESTJ',
  'ESFJ',
  'ENFJ',
  'ENTJ',
];

const store = useMatchStore();

const isSubmitted = ref(false);
const isSaved = ref(false);
const myMBTI = computed(() => store.myMBTI);
const opponentMBTI = computed(() => store.opponentMBTI);
const matchResult = computed(() => store.matchResult);
const isLoading = computed(() => store.isLoading);

const updateMyMBTI = (value) => {
  store.updateMyMBTI(value);
  isSubmitted.value = false;
  isSaved.value = false;
};
const updateOpponentMBTI = (value) => {
  store.updateOpponentMBTI(value);
  isSubmitted.value = false;
  isSaved.value = false;
};

const onClickCalculate = () => {
  isSubmitted.value = true;
  store.fetchMatchResult();
};

const onClickSaveResult = () => {
  store.saveResult();
  isSaved.value = true;
};
</script>
