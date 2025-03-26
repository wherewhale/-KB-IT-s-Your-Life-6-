<!-- <template>
  <div class="child">
    <h2>Child3</h2>
  </div>
</template>

<script>
export default {
  name: 'Child3',
};
</script>

<style scoped>
.child {
  background-color: orange;
  border: solid 1px black;
  margin: 1.5em;
  padding: 1em;
}
</style> -->

<template>
  <div :class="$style.child">
    <h2>Child3</h2>
  </div>
</template>
<script>
export default {
  name: 'Child3',
  created() {
    // this.$style.child.backgroundColor = 'blue'; 와 같은 형식으로도 사용이 가능하다.
    console.log(this.$style);
  },
};
</script>
<style module>
.child {
  background-color: orange;
  border: solid 1px black;
  margin: 1.5em;
  padding: 1em;
}
</style>
