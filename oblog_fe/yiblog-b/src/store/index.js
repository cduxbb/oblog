import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    userName: '',
    password: '',
    action: '',
    isLogin: true
  },
  mutations: {
    setUserName(state, userName) {
      state.userName = userName
    },
    setPassword(state, password) {
      state.password = password
    },
    setAction(state, action) {
      state.action = action
    },
    setIslogin(state, isLogin) {
      state.isLogin = isLogin
    }
  }
})
export default store