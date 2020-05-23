<template>
  <div>
    <div class="container-fluid">
      <div class="container">
        <!-- 面包屑导航 -->
        <nav aria-label="breadcrumb">
          <ol class="breadcrumb" style="font-size:12px">
            <li class="breadcrumb-item ml-5">
              <a href="#">
                <i class="icon-sphere"></i>
              </a>
            </li>
            <li class="breadcrumb-item">
              <a href="#">Library</a>
            </li>
            <li class="breadcrumb-item active" aria-current="page">Data</li>
          </ol>
        </nav>
      </div>
    </div>
    <div class="title">
      <div class="container">
        <p class="h2">{{title}}</p>
        <div class="post-meta mt-2">
          <img src="/Yi.jpg" width="40px" height="40px" class="rounded-circle ml-2 float-left" />
          <a class="text-decoration-none yi-middle mt-2 ml-2 text-dark" href="#">Yi</a>
          <span class="yi-middle mt-2">发布于3天前</span>
          <div></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getAllBlogById } from "@/network/index.js";
export default {
  data() {
    return {
      titel: ""
    };
  },
  created() {
    getAllBlogById(this.$route.params.id)
      .then(res => {
        this.title = res.data.title;
      })
      .catch(err => {
        console.log(err);
      });
  }
};
</script>
<style scoped lang="less">
@import "@/assets/style.css";
.container-fluid {
  background-color: #e9ecef;
}
.title {
  padding: 20px 0px;
}
.post-meta {
  height: 40px;
}
.post-meta > * {
  font-size: 13px;
}
.yi-middle {
  float: none;
  display: inline-block;
  vertical-align: middle;
}
</style>