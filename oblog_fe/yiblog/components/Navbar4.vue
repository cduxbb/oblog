<template>
  <div>
    <div class="container-fluid bg-dark">
      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
          <a class="navbar-brand" href="#">
            <img src="/Yi.jpg" width="30" height="30" alt />
          </a>
          <div class="collapse navbar-collapse yi-nav" id="navbarTogglerDemo02">
            <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
              <li class="nav-item" v-for="item in lis" :key="item" style="font-size:13px">
                <a class="nav-link" href="#">{{item}}</a>
              </li>
            </ul>
          </div>
          <div class="seach-bar">
            <form class="form-inline my-2 my-lg-0">
              <input class="form-control mr-sm-2" type="search" placeholder="Search" />
              <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
            </form>
          </div>
          <button
            class="navbar-toggler"
            type="button"
            data-toggle="collapse"
            data-target="#navbarTogglerDemo02"
            aria-controls="navbarTogglerDemo02"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>
        </div>
      </nav>
    </div>
  </div>
</template>

<script>
import $ from "jquery/dist/jquery.min.js";
import bootstrap from "bootstrap/dist/js/bootstrap.min.js";
export default {
  data() {
    return {
      lis: ["首页", "关于", "博客", "联系"],
      showList: false
    };
  }
};
</script>
<style scoped lang="less">
@import "assets/style.css";
.container {
  position: relative;
}

::-webkit-input-placeholder {
  color: white;
}
:-moz-placeholder {
  /* Firefox 18- */
  color: white;
}
::-moz-placeholder {
  /* Firefox 19+ */
  color: white;
}
:-ms-input-placeholder {
  color: white;
}
</style>