<template>
  <div class="row">
    <div class="col p-3">
      <!-- router-link는 최종적으로 a태그로 변환되어서 나온다. -->
      <!-- 그리고 class는 a태그에 붙어서 나온다고 보면 된다. -->
      <router-link class="btn btn-primary" to="/todos/add">
        할일 추가
      </router-link>
      <button class="btn btn-primary ms-1" @click="fetchTodoList">
        새로 고침
      </button>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <!-- todoList는 computed 속성 -->
        <TodoItem
          v-for="todoItem in todoList"
          :key="todoItem.id"
          :todoItem="todoItem"
        />
      </ul>
    </div>
  </div>
</template>
<script setup>
import { inject } from 'vue';
import TodoItem from '@/components/TodoItem.vue';
const todoList = inject('todoList');
</script>
