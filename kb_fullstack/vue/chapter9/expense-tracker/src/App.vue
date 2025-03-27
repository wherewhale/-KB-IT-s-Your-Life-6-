<style scoped></style>

<template>
  <div class="layout">
    <header>
      <h1 class="green title">💸 Simple Budget Diary</h1>
    </header>

    <main>
      <div class="container">
        <!-- <MyComponent @some-event="callback" /> -->
        <ExpenseForm @add-expense="addExpense" />

        <!-- 컴포넌트 분리 -->
        <ExpenseList
          :expenses="state.expenses"
          @delete-expense="deleteExpense"
        />

        <ExpenseCategory :categories="categoryAmountList" />

        <!-- 컴포넌트 분리 -->
        <TotalDisplay :totalAmount="totalAmount" :formatNumber="formatNumber" />
      </div>
    </main>
  </div>
</template>

<script setup>
import { reactive, computed } from 'vue';
import TotalDisplay from './components/TotalDisplay.vue';
import ExpenseForm from './components/ExpenseForm.vue';
import ExpenseList from './components/ExpenseList.vue';
import ExpenseCategory from './components/ExpenseCategory.vue';

const totalAmount = computed(() => {
  const total = state.expenses.reduce((sum, expense) => {
    return sum + expense.amount;
  }, 0);
  return total;
});

const categoryAmountList = computed(() => {
  const categoryAmount = {};
  state.expenses.forEach((expense) => {
    if (categoryAmount[expense.category]) {
      categoryAmount[expense.category] += expense.amount;
    } else {
      categoryAmount[expense.category] = expense.amount;
    }
  });

  return Object.entries(categoryAmount).map(([category, amount]) => {
    return {
      category,
      amount,
    };
  });
});

const state = reactive({
  expenses: [],
});

// 지출 내역 추가 함수
const addExpense = (expense) => {
  state.expenses.push(expense);
};

// 값 포맷팅 함수
const formatNumber = (number) => {
  return `₩${number.toLocaleString()}`;
};

const deleteExpense = (index) => {
  state.expenses.splice(index, 1);
};
</script>
