<template>
  <div class="container">
    <Header></Header>
    <router-view />
    <Loading v-if="states.isLoading" />
  </div>
</template>

<script setup>
import { reactive, computed, provide } from 'vue';
import Header from '@/components/Header.vue';
import Loading from '@/components/Loading.vue';

const BASEURI = '/api/todos';
const states = reactive({ todoList: [], isLoading: false });

//TodoList 목록을 조회합니다.
const fetchTodoList = async () => {
  states.isLoading = true;
  try {
    const response = await axios.get(BASEURI);
    if (response.status === 200) {
      states.todoList = response.data;
      // todoList를 states 객체로 래핑했기 때문에, 한 번에 할당이 가능
    } else {
      alert('데이터 조회 실패');
    }
  } catch (error) {
    alert('에러발생 :' + error);
  }
  states.isLoading = false;
};

const addTodo = async ({ todo, desc }, successCallback) => {
  states.isLoading = true;
  try {
    const payload = { todo, desc };
    const response = await axios.post(BASEURI, payload);
    //payload는 헤더와 data로 나눠진 packet에서 data 파트를 의미한다.
    if (response.status === 201) {
      // ...(spread 연산자)를 이용하여 현재 가진 정보를 펼치고, 새로운 정로를 추가해서, 새로운 객체로 대체
      // 이런 방식의 코드는 객체를 복사해야 하는 경우에도 자주 사용된다.
      states.todoList.push({ ...response.data, done: false });
      successCallback();
      // 여기의 callback 또한, 화면 이동이 될 수 있다.
    } else {
      alert('Todo 추가 실패');
    }
  } catch (error) {
    alert('에러발생 :' + error);
  }
  states.isLoading = false;
};

const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
  states.isLoading = true;
  try {
    const payload = { id, todo, desc, done };
    const response = await axios.put(BASEURI + `/${id}`, payload);
    if (response.status === 200) {
      let index = states.todoList.findIndex((todo) => todo.id === id);
      states.todoList[index] = payload;
      successCallback();
    } else {
      alert('Todo 변경 실패');
    }
  } catch (error) {
    alert('에러발생 :' + error);
  }
  states.isLoading = false;
};

const deleteTodo = async (id) => {
  states.isLoading = true;
  try {
    const response = await axios.delete(BASEURI + `/${id}`);
    console.log(response.status, response.data);
    if (response.status === 200) {
      let index = states.todoList.findIndex((todo) => todo.id === id);
      // Array 클래스에 아래 내용을 프로토타입으로 일반화해서 removeAt()으로 사용할 수 있다.
      // Array.prototype.removeAt() 형식으로 사용 가능
      states.todoList.splice(index, 1);
    } else {
      alert('Todo 삭제 실패');
    }
  } catch (error) {
    alert('에러발생 :' + error);
  }
  states.isLoading = false;
};

const toggleDone = async (id) => {
  states.isLoading = true;
  try {
    let todo = states.todoList.find((todo) => todo.id === id);
    let payload = { ...todo, done: !todo.done };
    const response = await axios.put(BASEURI + `/${id}`, payload);
    if (response.status === 200) {
      todo.done = payload.done;
    } else {
      alert('Todo 완료 변경 실패');
    }
  } catch (error) {
    alert('에러발생 :' + error);
  }
  states.isLoading = false;
};
// todoList를 computed로 정보를 반환
// provide는 읽기 전용으로 사용할 데이터를 제공한다.
// 데이터 제공의 원칙은 제공하는 곳에서 수정이 이뤄져야 한다는 점이다.
provide(
  'todoList',
  computed(() => states.todoList)
);
provide('actions', {
  addTodo,
  deleteTodo,
  toggleDone,
  updateTodo,
  fetchTodoList,
});
fetchTodoList();
</script>
