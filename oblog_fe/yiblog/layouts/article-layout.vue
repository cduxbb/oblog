<template>
  <div>
    <navbar></navbar>
    <bread-crumb></bread-crumb>
    <nuxt />
  </div>
</template>

<script>
import Navbar from "@/components/Navbar";
import BreadCrumb from "@/components/Breadcrumb";
export default {
  components: {
    BreadCrumb,
    Navbar
  }
};
</script>
<style scoped lang="less">
</style>