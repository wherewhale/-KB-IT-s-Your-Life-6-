<template>
  <div>
    <hr />
  </div>
</template>
<script>
export default {
  name: 'App',
  data() {
    return {
      todoLists: [],
    };
  },
  methods: {
    addTodo() : {
        // TODO: 수정 필요
        this.todoLists.push({
          title: '',
          completed: false,
        });
    },
    deleteTodo() : {
        // TODO: 수정 필요
        this.todoLists = this.todoLists.filter(todo =>!todo.completed);
    },
    toggleCompleted() : {
        // TODO: 수정 필요
        this.todoLists.forEach(todo => todo.completed =!todo.completed);
    },
  }
};
</script>
