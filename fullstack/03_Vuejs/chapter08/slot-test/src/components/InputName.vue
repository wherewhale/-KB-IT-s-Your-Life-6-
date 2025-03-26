<template>
  <!-- update 이벤트에 name이라는 값을 넘겨준다. 여기서는 v-model을 사용하면 안된다. -->
  <input
    type="text"
    :value="name"
    @input="$emit('update:name', $event.target.value)"
  />
</template>
<script>
export default {
  name: 'InputName',
  props: ['name'],
};
</script>
