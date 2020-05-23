<template>
  <div>
    <navbar></navbar>
    <nuxt />
  </div>
</template>

<script>
import Navbar from "@/components/Navbar";
import $ from "jquery/dist/jquery.min.js";
import bootstrap from "bootstrap/dist/js/bootstrap.min.js";
export default {
  components: {
    Navbar
  }
};
</script>
<style lang="less">
</style>