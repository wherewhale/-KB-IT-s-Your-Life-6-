<template>
  <div>
    <!-- 여기서 nameChanged는 자식 컴포넌트에서 결정하는 사항 -->
    <InputName @nameChanged="nameChangedHandler" />

    <br />
    <h3>App 데이터 : {{ parentName }}</h3>
  </div>
</template>

<script>
import InputName from './components/InputName.vue';
export default {
  name: 'App4',
  components: { InputName },
  data() {
    return {
      parentName: '',
    };
  },
  methods: {
    nameChangedHandler(e) {
      this.parentName = e.name;
    },
  },
};
</script>
