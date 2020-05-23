<template>
  <div>
    <div class="container mt-3">
      <div class="row">
        <main class="col-lg-8 col-md-8 col-sm-12">
          <div>
            <img src="/long.jpg" class="img-fluid" alt="Responsive image" />
          </div>
          <div class="article-content" v-html="content"></div>
        </main>
        <aside class="col-lg-4 col-md-4 col-sm-12"></aside>
      </div>
    </div>
  </div>
</template>

<script>
import { getAllBlogById } from "@/network/index.js";
export default {
  layout: "article-layout",
  data() {
    return {
      content: ""
    };
  },
  created() {
    getAllBlogById(this.$route.params.id)
      .then(res => {
        this.content = res.data.content;
      })
      .catch(err => {
        console.log(err);
      });
  }
};
</script>
<style scoped lang="less">
</style>