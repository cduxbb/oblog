import Router from 'vue-router'
import Vue from 'vue'

Vue.use(Router)

import Blog from '../components/blog/blog.vue'
import Login from '../components/login&register/login.vue'
import add from "../components/bloger/add.vue"
import query from "../components/bloger/query.vue"
import write from "../components/blog/write.vue"
import log from '../components/journal/log.vue'
// 2.配置路由和组件之间的应用关系，每一个关系都是一个对象
const routes = [{
    path: '/',
    component: Login
  },
  {
    path: '/blog',
    component: Blog
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  },
  {
    path: '/add',
    component: add
  },
  {
    path: '/query',
    component: query
  },
  {
    path: '/write',
    component: write
  },
  {
    path: '/log',
    component: log
  }
]

// 2.创建 VueRouter对象
const router = new Router({
  // 配置路由和组件之间的关系
  routes,
  mode: "history"
})

// router.af((to, from, next) => {
//   if (to.name === "/login") {
//     this.$store.commit('setIslogin', true)
//   } else {
//     console.log(this);
//     next((vm) => {
//       vm.$store.name 
//     })
//     this.$store.commit('setIslogin', false)
//   }
//   next()
// })

export default router