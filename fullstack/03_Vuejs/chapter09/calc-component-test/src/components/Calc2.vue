<template>
  <div>
    X : <input type="text" v-model.number="x" />
    <br />
    Y : <input type="text" v-model.number="y" />
    <br />
    <button @click="calcAdd">계산</button><br />
    <div>결과 : {{ result }}</div>
  </div>
</template>

<script>
import { ref } from 'vue';
export default {
  name: 'Calc2',
  setup() {
    const x = ref(10);
    const y = ref(20);
    const result = ref(30);
    // 화살표 함수를 작성해서 클로저를 활용하는 방식으로 구현한다.
    // 과거에는 methods를 활용해서 메서드를 구현했지만, setup()은 함수 내부에 구현하므로 데이터 접근이 용이하다.
    const calcAdd = () => {
      result.value = x.value + y.value;
    };
    return { x, y, result, calcAdd }; //템플릿에서 바로 사용할 수 있는 대상이 된다.
  },
};
</script>
