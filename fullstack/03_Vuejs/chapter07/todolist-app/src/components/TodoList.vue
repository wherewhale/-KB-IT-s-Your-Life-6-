<template>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <!-- :todoItem="todoItem" 데이터 전달 -->
        <!-- delete 어쩌고, toggle 어쩌고는 이벤트 중개 -->
        <!-- $event : 자식 컴포넌트에서 발생한 이벤트의 인자 -->
        <TodoListItem
          v-for="todoItem in todoList"
          :key="todoItem.id"
          :todoItem="todoItem"
          @delete-todo="$emit('delete-todo', $event)"
          @toggle-completed="$emit('toggle-completed', $event)"
        />
      </ul>
    </div>
  </div>
</template>

<script>
import TodoListItem from './TodoListItem.vue';
export default {
  name: 'TodoList',
  components: { TodoListItem },
  props: {
    todoList: { type: Array, required: true },
  },
  emits: ['delete-todo', 'toggle-completed'],
};
</script>
