<!-- 이번에는 지출 목록 렌더링 부분을 ExpenseList.vue라는 컴포넌트로 분리하고,
props를 통해 지출 배열을 전달받아 리스트를 그리는 구조로 변경하세요.
:클립보드: 요구사항
새 컴포넌트 파일 ExpenseList.vue를 만들어야 합니다.
props로 지출 목록 배열(expenses)을 전달받아 <li> 형태로 렌더링합니다.
지출 항목은 다음과 같은 형식으로 표시되어야 합니다:"🍔 점심: 8000원""☕ 커피: 3500원"
항목마다 고유 키를 주기 위해 index를 :key로 사용하세요.
Composition API + defineProps()를 활용하세요. -->

<style scoped>
.expense-item {
  display: flex;
  justify-content: space-between;
  gap: 2rem;
  padding: 1rem;
  border-radius: 12px;
  background-color: rgba(84, 84, 84, 0.65);
  color: white;
  margin-bottom: 1rem;
}
.delete-button {
  border-radius: 12px;
  background: none;
  color: white;
  border: 0;
  cursor: pointer;
}
</style>

<template>
  <section>
    <h2 class="subtitle">🧾 지출 내역</h2>
    <ul>
      <li
        v-for="(expense, idx) in expenseList"
        class="expense-item"
        :key="expense.id"
      >
        <span
          >{{ expense.expense }} :
          {{ expense.amount.toLocaleString() }} 원</span
        >

        <button class="delete-button" @click="emit('delete-expense', idx)">
          ❌
        </button>
      </li>
    </ul>
  </section>
</template>

<script setup>
import { defineProps, computed } from 'vue';

const expenseFormat = (expense) => {
  if (expense.includes('커피')) {
    return '☕ ' + expense;
  } else if (expense.includes('점심')) {
    return '🍔 ' + expense;
  } else if (expense.includes('택시')) {
    return '🚕 ' + expense;
  } else {
    return '🪙 ' + expense;
  }
};

const props = defineProps({
  expenses: {
    type: Array,
    required: true,
  },
});

const emit = defineEmits(['delete-expense']);

const expenseList = computed(() => {
  return props.expenses.map((expense) => {
    return {
      id: expense.id,
      expense: expenseFormat(expense.expense),
      amount: expense.amount,
    };
  });
});
</script>
