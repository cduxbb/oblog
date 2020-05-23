<template>
  <div>
    <div class="container">
      <div class="row row-cols-1 row-cols-md-3">
        <div class="col mb-4" v-for="item in articles" :key="item">
          <div class="card h-100">
            <img src="/long.jpg" class="card-img-top" alt="..." />
            <div class="card-body">
              <h5 class="card-title">{{item.title}}</h5>
              <p class="card-text yi-p">{{item.content}}</p>
              <router-link :to="'/article/'+item.blogId">详情</router-link>
            </div>
          </div>
        </div>
      </div>
    </div>
    <nav aria-label="首页的分页">
      <ul class="pagination justify-content-center">
        <li class="page-item disabled">
          <a class="page-link" href="#" tabindex="-1" aria-disabled="true">前一个</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">1</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">2</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">3</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">下一个</a>
        </li>
      </ul>
    </nav>
  </div>
</template>

<script>
import { getAllBlogByPageNum } from "@/network/index.js";
import { log } from "util";
export default {
  layout: "index-layout",
  data() {
    return {
      articles: []
    };
  },
  created() {
    getAllBlogByPageNum(1)
      .then(res => {
        this.articles = res.data;
        log(res.data);
      })
      .catch(err => {
        console.log(err);
      });
  }
};
</script>

<style scoped>
.container {
  margin: 30px auto;
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
}

.title {
  font-family: "Quicksand", "Source Sans Pro", -apple-system, BlinkMacSystemFont,
    "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
  display: block;
  font-weight: 300;
  font-size: 100px;
  color: #35495e;
  letter-spacing: 1px;
}

.subtitle {
  font-weight: 300;
  font-size: 42px;
  color: #526488;
  word-spacing: 5px;
  padding-bottom: 15px;
}

.links {
  padding-top: 15px;
}

.yi-p {
  height: 50px;
  width: 100%;
  overflow: hidden;
  text-overflow: ellipsis;
  -webkit-line-clamp: 2;
  word-break: break-all;
  display: -webkit-box;
  -webkit-box-orient: vertical;
}
</style>
