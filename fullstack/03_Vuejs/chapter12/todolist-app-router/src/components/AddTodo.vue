<template>
  <div class="row">
    <div class="col p-3">
      <h2>할일 추가</h2>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <div class="form-group">
        <label htmlFor="todo">할일 :</label>
        <input
          type="text"
          class="form-control"
          id="todo"
          v-model="todoItem.todo"
        />
      </div>
      <div class="form-group">
        <label htmlFor="desc">설명 :</label>
        <textarea
          class="form-control"
          rows="3"
          id="desc"
          v-model="todoItem.desc"
        ></textarea>
      </div>
      <div class="form-group">
        <!-- addTodoHandler를 실행하면 목록으로 이동하는 것이 일반적이다. -->
        <!-- 버튼을 구성할 때에는 아이콘을 같이 넣어주면 좋다. -->
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="addTodoHandler"
        >
          추 가
        </button>
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="router.push('/todos')"
        >
          취 소
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { inject, reactive } from 'vue';
import { useRouter } from 'vue-router';
const router = useRouter();
const { addTodo } = inject('actions');
const todoItem = reactive({ todo: '', desc: '' });
const addTodoHandler = () => {
  let { todo } = todoItem;
  if (!todo || todo.trim() === '') {
    alert('할일은 반드시 입력해야 합니다');
    return;
  }
  // 여기서 왜 ...todoItem을 했을까?
  // todoItem은 reactive로 만든 Proxy 객체이기 때문이다.
  // 순수한 데이터 객체로 만들어서 이를 추가하기 위해서 spread 연산자를 사용한 것이다.

  //   addTodo({ ...todoItem });
  //   router.push('/todos');

  // 화살표 함수를 이용하여, callback함수를 구성한 것을 볼 수 있다.
  // 이렇게 구성한 이유는 비동기 처리를 하기 위함이다.
  // 위 코드를 유지하면, addTodo의 결과와 상관없이 화면을 전환해버린다.
  addTodo({ ...todoItem }, () => {
    router.push('/todos');
  });
};
</script>
