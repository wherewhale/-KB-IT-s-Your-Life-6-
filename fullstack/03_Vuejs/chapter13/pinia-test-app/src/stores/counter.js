import { ref, computed } from 'vue';
import { defineStore } from 'pinia';

export const useCounterStore = defineStore('counter', () => {
  const count = ref(0);
  const doubleCount = computed(() => count.value * 2);
  // 현재 상태 값을 두 배로 만들어줌
  function increment() {
    count.value++;
  }

  // 다른 컴포넌트에서 상태에 접근하기 위해 사용할 수 있는 getter를 정의
  // 상태를 직접 내보내면 외부에서 상태를 변경할 수 있으므로, getter를 사용하여 상태를 보호
  return { count, doubleCount, increment };
});
