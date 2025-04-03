<template>
  <div class="row">
    <div class="col p-3">
      <h2>할일 수정</h2>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <div class="form-group">
        <label htmlFor="todo">할일:</label>
        <input
          type="text"
          class="form-control"
          id="todo"
          v-model="todoItem.todo"
        />
      </div>
      <div class="form-group">
        <label htmlFor="desc">설명:</label>
        <textarea
          class="form-control"
          rows="3"
          id="desc"
          v-model="todoItem.desc"
        ></textarea>
      </div>
      <div class="form-group">
        <label htmlFor="done">완료여부 : </label>&nbsp;
        <input type="checkbox" v-model="todoItem.done" />
      </div>
      <div class="form-group">
        <!-- 수정 과정에서 여러번 이뤄지지 않도록 :disabled에 계산된 속성을 넣어, 막아주는 UX도 구성하는 것이 좋다.  -->
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="updateTodoHandler"
        >
          수 정
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
import { useRouter, useRoute } from 'vue-router';
const todoList = inject('todoList');
const { updateTodo } = inject('actions');
const router = useRouter();
const currentRoute = useRoute();
// find 함수 실행 후, 값이 없다면 -1 리턴
// const matchedTodoItem = todoList.value.find(
//   (item) => item.id === parseInt(currentRoute.params.id)
// );
// -1이 리턴되면 실행될 수 있도록 조건 설정
const matchedTodoItem = todoList.value.find(
  (item) => item.id === currentRoute.params.id
);
if (!matchedTodoItem) {
  router.push('/todos');
}
// 여기는 왜 spread 연산자를 사용했을까?
// matchedTodoItem을 그대로 사용하게 되면, 바로 원본이 변경된다.
// 취소를 위해 복사를 통해 사용하며, 원본에 직접 접근하지 않도록 하여 데이터를 유지시킨다.
const todoItem = reactive({ ...matchedTodoItem });
const updateTodoHandler = () => {
  let { todo } = todoItem;
  // 이런 형식의 작업을 유효성 검사라고 부른다. (필수 항목 체크 및 양식 체크 등등)
  if (!todo || todo.trim() === '') {
    alert('할일은 반드시 입력해야 합니다');
    return;
  }
  //   updateTodo({ ...todoItem });
  //   router.push('/todos');
  updateTodo({ ...todoItem }, () => {
    router.push('/todos');
  });
};
</script>
