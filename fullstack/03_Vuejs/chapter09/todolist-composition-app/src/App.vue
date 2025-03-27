<script setup>
import { reactive, onMounted } from 'vue';
import InputTodo from './components/InputTodo.vue';
import TodoList from './components/TodoList.vue';
const ts = new Date().getTime();
const state = reactive({ todoList: [] });
onMounted(() => {
  state.todoList.push({ id: ts, todo: '자전거 타기', completed: false });
  state.todoList.push({ id: ts + 1, todo: '딸과 공원 산책', completed: true });
  state.todoList.push({
    id: ts + 2,
    todo: '일요일 애견 카페',
    completed: false,
  });
  state.todoList.push({ id: ts + 3, todo: 'Vue 원고 집필', completed: false });
});
</script>
