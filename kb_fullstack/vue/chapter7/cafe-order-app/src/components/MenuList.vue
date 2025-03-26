<style>
button {
  padding: 10px;
  margin: 5px;
  cursor: pointer;
}
</style>

<template>
  <button type="button" @click="$emit('select-drink')">
    {{ menu.name }} ({{ menu.price }}원)
  </button>
</template>

<script>
export default {
  name: 'MenuList',
  props: {
    menu: {
      type: Object,
      required: true,
    }, //옵션
  },
  emits: ['select-drink'],
  data() {
    return {};
  },
};
</script>
