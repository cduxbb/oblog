<template>
  <div class="container-wrap">
    <div class="container" id="container">
      <!-- 注册页面 -->
      <div class="form-container sign-up-container">
        <form action="#">
          <h1>sign up</h1>
          <!-- 公共组件 -->
          <div class="social-container">
            <a href="#">
              <i class="fab fa-qq"></i>
            </a>
            <a href="#">
              <i class="fab fa-weixin"></i>
            </a>
            <a href="#">
              <i class="fab fa-weibo"></i>
            </a>
          </div>
          <input type="text" name="userName" placeholder="userName..." />
          <input type="email" name="email" id="email" placeholder="Email..." />
          <input type="password" name="password" id="password" placeholder="Password..." />
          <button>sign up</button>
        </form>
      </div>

      <!-- 登录页面 -->
      <div class="form-container sign-in-container">
        <div class="form">
          <h1>sign in</h1>
          <!-- 公共组件 -->
          <div class="social-container">
            <a href="#">
              <i class="fab fa-qq"></i>
            </a>
            <a href="#">
              <i class="fab fa-weixin"></i>
            </a>
            <a href="#">
              <i class="fab fa-weibo"></i>
            </a>
          </div>
          <input type="text" name="userName" placeholder="userName..." v-model="userName" />
          <input type="password" name="password" placeholder="Password..." v-model="password" />
          <a href="#" class="forget">forget your password</a>
          <button @click="commit()">sign up</button>
        </div>
      </div>

      <!-- 覆盖容器 -->
      <div class="overlay-container">
        <div class="overlay">
          <!-- 覆盖左边 -->
          <div class="overlay-penal overlay-left-container">
            <h1>welcome back!</h1>
            <p>To keep connected with us please login with your personal info</p>
            <button class="ghost" id="signIn">sign in</button>
          </div>

          <!-- 覆盖右边 -->
          <div class="overlay-penal overlay-right-container">
            <h1>Hello Friend!</h1>
            <p>Enter your personal details and start journey with us</p>
            <button class="ghost" id="signUp">sign up</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { login } from "../../network/bloger";
export default {
  name: "Login",
  data() {
    return {
      userName: "",
      password: ""
    };
  },
  methods: {
    commit() {
      login(this.userName, this.password)
        .then(res => {
          if (false) {
            alert("账号或密码错误");
          } else {
            alert("登录成功");
            this.$store.state.isLogin = false;
            this.$store.state.userName = this.userName;
            this.$store.state.password = this.password;
            this.$router.push("/blog");
          }
        })
        .catch(err => {
          alert("登录失败");
        });
    }
  }
};
</script>
<style src="../../assets/css/main.css" scoped>
</style>
<style src="../../assets/css/all.css" scoped>
</style>
<style scoped lang="less">
</style>