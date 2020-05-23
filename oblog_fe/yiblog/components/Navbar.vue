<template>
  <header class="clear">
    <!-- 设置响应式 -->
    <div class="container-fluid">
      <div class="row">
        <div class="col-xs-11 col-sm-10 col-md-9 m-auto">
          <!-- 设置内容基本区 -->
          <div class="content">
            <div class="row no-gutters">
              <!-- 头像 -->
              <div class="avatar mr-3">
                <div class="imgbox">
                  <a href="#" class="thumbnail">
                    <img src="/Yi.jpg" width="32px" height="32px" style="center-block" />
                  </a>
                </div>
              </div>
              <!-- 列表:只在lg及其以上可见,并且长度随着父元素改变而改变 -->
              <div class="d-none d-lg-block col">
                <div class="lists">
                  <ul class="list-inline">
                    <a href></a>
                    <li class="list-inline-item ml-3" v-for="(item,index) in lis" :key="index">
                      <a href="#" class="font-weight-bold text-light">{{item}}</a>
                    </li>
                  </ul>
                </div>
              </div>
              <!-- 输入框：lg以上显现并且是固定宽度 -->
              <div class="d-none d-lg-block">
                <form class="lg-headform d-table" action="#">
                  <!-- 输入框 -->
                  <input placeholder="快来搜索啊！" class="w-100 d-table-cell text-white" type="text" />
                  <!-- 按钮 -->
                  <span class="d-table-cell iconbox">
                    <i class="icon-search"></i>
                  </span>
                </form>
              </div>
              <!-- 输入框：lg以下显现并且宽度为col -->
              <div class="d-lg-none col mr-3">
                <form class="d-table w-100" action="#">
                  <input placeholder="快来搜索啊!" class="w-100" type="d-table-cell text-white" />
                  <span class="d-table-cell iconbox">
                    <i class="icon-search"></i>
                  </span>
                </form>
              </div>
              <!-- 折叠框：lg以下显现 -->
              <div class="d-lg-none">
                <div class="cop">
                  <i class="icon-menu" @click="showList=!showList"></i>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <transition name="fade">
      <div class="d-lg-none list-group yi-lists" v-if="showList">
        <a
          href="#"
          class="list-group-item bg-dark text-white"
          v-for="item in lis"
          :key="item.id"
        >{{ item }}</a>
      </div>
    </transition>
  </header>
</template>

<script>
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
.yi-lists {
  position: absolute;
  width: 100%;
}
.list-group-item {
  border-radius: 0%;
}
.fade-enter-active,
.fade-leave-active {
  transition: opacity 1s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}
.container-fluid {
  height: 60px;
  background: black;
}

.content {
  height: 60px;
  padding: 14px;
  box-sizing: border-box;
}

.content > .row > div:not(:first-child) {
  height: 32px;
  line-height: 32px;
  font-size: 12px;
}
a {
  text-decoration: none;
}
.list-inline a:hover {
  color: white;
}

.lg-headform {
  width: 300px;
}

.iconbox {
  position: relative;
  border-left: 1px solid rgba(255, 255, 255, 0.2);
  width: 30px;
}
.iconbox > i {
  position: absolute;
  top: 1px;
  height: 30px;
  padding-left: 5px;
  width: 100%;
  background: #3c4044;
  display: inline-block;
  color: rgb(116, 118, 119);
  line-height: 30px;
  font-size: 15px;
}

.cop {
  height: 30px;
  width: 30px;
  line-height: 30px;
  margin-top: -5px;
}
.cop > i {
  color: #c8c9ca;
  font-size: 40px;
}
input {
  box-sizing: border-box;
  padding-left: 10px;
  height: 30px;
  background: #3c4044;
  outline: none;
  border: 0px;
  color: aliceblue;
}
.list-group {
  z-index: 100;
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