<template>
  <div class="container">
    <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
      <el-radio-button :label="false">展开</el-radio-button>
      <el-radio-button :label="true">收起</el-radio-button>
    </el-radio-group>
    <el-menu
      class="el-menu-vertical-demo el-menu"
      background-color="#545c64"
      text-color="#fff"
      active-text-color="#ffd04b"
      :collapse="isCollapse"
    >
      <!-- 文章 -->
      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>文章</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="1-1">
            <router-link to="/blog" class="link">所有文章</router-link>
          </el-menu-item>
          <el-menu-item index="1-2">
            <router-link to="/write" class="link">写文章</router-link>
          </el-menu-item>
          <el-menu-item index="1-3">分类目录</el-menu-item>
          <el-menu-item index="1-4">标签</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <!-- 评论 -->
      <el-menu-item index="2">
        <i class="el-icon-menu"></i>
        <span slot="title">
          <router-link to="/log" class="link">日志</router-link>
        </span>
      </el-menu-item>
      <!-- 用户 -->
      <el-submenu index="3">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>用户</span>
        </template>
        <el-menu-item-group class="group">
          <el-menu-item index="3-1">
            <router-link to="/query" class="link">查询用户</router-link>
          </el-menu-item>
          <el-menu-item index="3-2">
            <router-link to="/add" class="link">添加用户</router-link>
          </el-menu-item>
          <el-menu-item index="3-3">我的个人资料</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <!-- 页面 -->
      <el-submenu index="4">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>页面</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="1-1">所有页面</el-menu-item>
          <el-menu-item index="1-2">新建页面</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "yiHeader",
  data() {
    return {
      isCollapse: false
    };
  }
};
</script>
<style scoped lang="less">
.container {
  overflow: hidden;
}
.el-menu {
  height: 100%;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 160px;
}
.link {
  color: white;
  text-decoration: none;
}
.link :invalid {
  color: gold;
  text-decoration: none;
}
</style>