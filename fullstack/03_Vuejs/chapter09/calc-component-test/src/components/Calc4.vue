<template>
  <div>
    <br />
    <br />
  </div>
</template>
X :
<input type="text" v-model.number="state.x" />
Y :
<input type="text" v-model.number="state.y" />
<div>결과 : {{ result }}</div>
<script>
import { reactive, computed } from 'vue';
export default {
  name: 'Calc4',
  setup() {
    const state = reactive({ x: 10, y: 20 });
    const result = computed(() => {
      return state.x + state.y;
    });
    return { state, result };
  },
};
</script>
