<template>
  <div>
    <input
      type="checkbox"
      :value="id"
      :checked="checked"
      @change="$emit('check-changed', { id, checked: $event.target.checked })"
    />
    <!-- 이때, 여러 개의 check 이벤트가 발생하기 때문에, id를 전달하여, 무엇이 체크됐는지 확인하도록 한다. -->
    <!-- $event는 vue가 html의 이벤트 객체에 접근할 때 사용하는 방식이다. -> checked라는 값에 html로부터 이벤트 객체 정보를 받아서 넘긴다. -->

    <span
      v-if="checked === true"
      style="color: blue; text-decoration: underline"
    >
      <i>{{ label }}</i>
    </span>
    <span v-else style="color: gray">{{ label }}</span>
  </div>
</template>
<script>
export default {
  name: 'CheckBox1',
  props: ['id', 'checked', 'label'],
};
</script>
