import { defineStore } from 'pinia';
import { reactive, computed } from 'vue';

// 'todoList'는 store의 식별자가 되어, $id라는 키의 값이 된다.
export const useTodoListStore = defineStore('todoList', () => {
  // 반응형 상태
  const state = reactive({
    todoList: [
      { id: 1, todo: 'ES6학습', done: false },
      { id: 2, todo: 'React학습', done: false },
      { id: 3, todo: 'ContextAPI 학습', done: true },
      { id: 4, todo: '야구경기 관람', done: false },
    ],
  });
  // action
  const addTodo = (todo) => {
    state.todoList.push({ id: new Date().getTime(), todo, done: false });
  };
  const deleteTodo = (id) => {
    let index = state.todoList.findIndex((todo) => todo.id === id);
    state.todoList.splice(index, 1);
  };
  const toggleDone = (id) => {
    let index = state.todoList.findIndex((todo) => todo.id === id);
    state.todoList[index].done = !state.todoList[index].done;
  };
  // 계산된 속성
  // Redux에서는 computed 함수를 사용하지 않아도 상태를 구독할 수 있지만, Pinia에서는 computed를 사용해야 한다.
  const doneCount = computed(() => {
    // todo 리스트에서 done이 true인 todo의 개수를 센다.
    return state.todoList.filter((todoItem) => todoItem.done === true).length;
  });
  const todoList = computed(() => state.todoList);
  // todoList, doneCount는 data 파트, addTodo, deleteTodo, toggleDone은 actions 파트에 해당한다.
  //   doneCount를 제외한 요소는 분해할당이 가능하다. 하지만, doneCount는 참조값이 아닌 원시값이기 때문에 분해할당이 불가능하다.
  return { todoList, doneCount, addTodo, deleteTodo, toggleDone };
});
