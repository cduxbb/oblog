<template>
  <el-table
    :data="tableData.filter(data => !search || data.userName.toLowerCase().includes(search.toLowerCase()))"
    style="width: 100%"
  >
    <el-table-column label="id" prop="id"></el-table-column>
    <el-table-column label="userName" prop="userName"></el-table-column>
    <el-table-column label="password" prop="password"></el-table-column>
    <el-table-column label="nickname" prop="nickname"></el-table-column>
    <el-table-column label="email" prop="email"></el-table-column>
    <el-table-column label="address" prop="address"></el-table-column>
    <el-table-column align="right">
      <template slot="header" slot-scope="scope">
        <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />
      </template>
      <template slot-scope="scope">
        <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
        <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import { queryBloger } from "../../network/bloger.js";
export default {
  data() {
    return {
      tableData: [
        {
          id: 14,
          userName: "MasterYi",
          password: "*",
          nickname: "MasterYi",
          email: "239",
          address: "中国四川",
          signature: ""
        }
      ],
      search: ""
    };
  },
  methods: {
    handleEdit(index, row) {
      console.log(index, row);
    },
    handleDelete(index, row) {
      console.log(index, row);
    }
  },
  created() {
    queryBloger("MasterYi")
      .then(res => {
        console.log(res.data);
      })
      .catch(err => {});
  }
};
</script>
<style scoped lang="less">
</style>