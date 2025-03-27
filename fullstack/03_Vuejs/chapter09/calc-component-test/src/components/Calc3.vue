<template>
  <div>
    X : <input type="text" v-model.number="state.x" />
    <br />
    Y : <input type="text" v-model.number="state.y" />
    <br />
    <button @click="calcAdd">계산</button><br />
    <div>결과 : {{ state.result }}</div>
  </div>
</template>
<script>
import { reactive } from 'vue';
export default {
  name: 'Calc3',
  setup() {
    // ref 대신 reactive를 사용한다.
    // ref는 단일 값을 처리하는 반면, reactive는 객체를 처리한다.
    // state 역시 Proxy 객체이며, setter가 override되어 state의 값의 변경을 감시한다.
    const state = reactive({ x: 10, y: 20, result: 30 });
    const calcAdd = () => {
      state.result = state.x + state.y;
    };
    return { state, calcAdd };
  },
};
</script>
