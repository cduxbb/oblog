<template>
  <div>
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="用户名">
        <el-input v-model="form.userName"></el-input>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="form.password"></el-input>
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="form.nickname"></el-input>
      </el-form-item>
      <el-form-item label="email">
        <el-input v-model="form.email"></el-input>
      </el-form-item>
      <el-form-item label="地址">
        <el-input v-model="form.address"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
        <el-button @click="clear()">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { addBloger } from "../../network/bloger.js";
export default {
  methods: {
    onSubmit() {
      addBloger(this.form)
        .then(res => {
          console.log(res.data);
          if (res.data === 200) {
            alert("添加成功");
            this.clear();
          } else {
            alert("添加失败");
          }
        })
        .catch(err => {
          console.log("failed to add");
        });
    },
    clear() {
      this.form = {
        userName: "",
        password: "",
        nickname: "",
        address: "",
        email: ""
      };
    }
  },

  data() {
    return {
      form: {
        userName: "",
        password: "",
        nickname: "",
        address: "",
        email: ""
      }
    };
  }
};
</script>
<style scoped lang="less">
</style>