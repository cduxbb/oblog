<template>
  <div id="app">
    <div v-if="$store.state.isLogin">
      <router-view></router-view>
    </div>
    <div v-else>
      <el-container>
        <el-header class="app-header" :height="'32px'">
          <yi-header></yi-header>
        </el-header>
        <el-container class="container">
          <el-aside width="160px">
            <yi-asider></yi-asider>
          </el-aside>
          <el-main>
            <yi-main></yi-main>
          </el-main>
        </el-container>
      </el-container>
    </div>
  </div>
</template>

<script>
import yiHeader from "./components/yiHeader";
import yiAsider from "./components/yiAsider";
import yiMain from "./components/yiMain";
import { log } from "util";
export default {
  name: "app",
  components: {
    yiHeader,
    yiAsider,
    yiMain
  },
  data() {
    return {
      routerName: this.$route.name
    };
  },
  mounted() {
    console.log(this.$store.state.isLogin);
  },
  computed: {
    isLogin() {
      console.log(this.routerName);
      if (this.routerName === "login") {
        console.log(true);
        return true;
      } else {
        return false;
      }
    }
  }
};
</script >

<style lang="less">
body {
  margin: 0px !important;
}
.app-header {
  padding: 0 !important;
}
.container {
  height: 700px;
}
</style>
