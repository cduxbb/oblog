<template>
  <div>
    <header>欢迎你：{{$store.state.userName}}</header>
  </div>
</template>

<script>
export default {
  name: "Memu",
  data() {
    return {
      activeIndex: "1",
      activeIndex2: "1"
    };
  }
};
</script>

<style scoped lang="less">
header {
  line-height: 32px;
  background: black;
  color: wheat;
}
</style>