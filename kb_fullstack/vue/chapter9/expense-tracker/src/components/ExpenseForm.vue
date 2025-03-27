<style scoped>
.form-container {
  display: flex;
  gap: 1rem;
}

input[type='text'],
input[type='number'] {
  padding: 1rem;
  border-radius: 12px;
  background-color: rgba(84, 84, 84, 0.65);
  color: white;
  border: 0;
  width: 100%;
}

.button-submit {
  padding: 1rem;
  border-radius: 12px;
  background-color: hsla(160, 100%, 37%, 1);
  color: white;
  border: 0;
  cursor: pointer;
  flex-shrink: 0;
}

select {
  padding: 1rem;
  border-radius: 12px;
  background-color: rgba(84, 84, 84, 0.65);
  color: white;
  border: 0;
}
</style>

<template>
  <form class="form-container" @submit.prevent="addExpense">
    <input type="text" placeholder="항목명 입력" v-model="expense" />
    <input type="number" v-model.number="amount" />
    <select v-model="category">
      <option v-for="category in CATEGORIES" :key="category" :value="category">
        {{ category }}
      </option>
    </select>
    <button class="button-submit" type="submit">추가</button>
  </form>
</template>

<script setup>
import { ref } from 'vue';

const CATEGORIES = ['🍽 식비', '🚌 교통비', '🎤 문화생활비', '🎸 기타'];

const expense = ref('');
const amount = ref(0);
const category = ref('🍽 식비');

const emit = defineEmits(['add-expense']);
const addExpense = () => {
  if (expense.value && amount.value) {
    emit('add-expense', {
      id: expense.value[0] + new Date(),
      expense: expense.value,
      amount: amount.value,
      category: category.value,
    });
    // 초기화
    expense.value = '';
    amount.value = 0;
    category.value = '🍽 식비';
  }
};
</script>
