// @/stores/matchStore.js
import { ref } from 'vue';
import { defineStore } from 'pinia';
import { getMatchResult, postMatchResult } from '@/api/match'; // 네가 만든 API 호출 함수

export const useMatchStore = defineStore('match', () => {
  const myMBTI = ref(null);
  const opponentMBTI = ref(null);
  const matchResult = ref(null);
  const isLoading = ref(false);

  const updateMyMBTI = (newMBTI) => {
    console.log('[updateMyMBTI]', newMBTI);
    myMBTI.value = newMBTI;
  };

  const updateOpponentMBTI = (newMBTI) => {
    console.log('[updateOpponentMBTI]', newMBTI);
    opponentMBTI.value = newMBTI;
  };

  const fetchMatchResult = async () => {
    console.log('[fetchMatchResult] 호출됨', myMBTI.value, opponentMBTI.value);
    const result = await getMatchResult(myMBTI.value, opponentMBTI.value);
    console.log('[결과]', result);
    matchResult.value = result;
  };

  const saveResult = async () => {
    console.log('[saveResult] 호출됨');
    isLoading.value = true;
    const response = await postMatchResult(matchResult.value[0]);
    isLoading.value = false;
    console.log('[결과]', response);
  };

  return {
    myMBTI,
    opponentMBTI,
    matchResult,
    updateMyMBTI,
    updateOpponentMBTI,
    fetchMatchResult,
    saveResult,
  };
});
