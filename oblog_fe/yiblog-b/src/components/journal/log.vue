<template>
  <div>
    <el-table
      :data="tableData"
      border
      style="width: 100%"
      ref="multipleTable"
      @selection-change="handleSelectionChange"
    >
      <el-table-column type="selection" width="55"></el-table-column>
      <el-table-column prop="logId" label="日志id" width="120"></el-table-column>
      <el-table-column prop="logTime" label="时间" width="120"></el-table-column>
      <el-table-column prop="ip" label="ip" width="120"></el-table-column>
      <!-- <el-table-column prop="content" label="内容" width="460" class="yi-content"></el-table-column> -->
      <el-table-column prop="visitUrl" label="访问路径" width="120"></el-table-column>
      <el-table-column prop="visitMethod" label="访问方法" width="500"></el-table-column>
    </el-table>
    <div style="margin-top: 20px">
      <el-button @click="toggleSelection()">取消选择</el-button>
      <el-button @click="multiplyDelete()">批量删除</el-button>
    </div>
  </div>
</template>

<script>
import { getAllLog, delMultiplylog } from "../../network/log";
import { log } from "util";
export default {
  name: "log",
  data() {
    return {
      tableData: [
        {
          logId: "",
          logTime: "",
          ip: "",
          visitUrl: "",
          visitMethod: ""
        }
      ],
      // 选中的数组
      multipleSelection: []
    };
  },
  methods: {
    multiplyDelete() {
      let delArr = this.multipleSelection.map(item => {
        return item.logId;
      });
      console.log(delArr);
      delMultiplylog(delArr);
      setTimeout(() => {
        getAllLog(1)
          .then(res => {
            this.tableData = res.data;
          })
          .catch(err => {});
      }, 500);
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
      console.log(this.multipleSelection);
    }
  },
  created() {
    getAllLog(1)
      .then(res => {
        this.tableData = res.data;
      })
      .catch(err => {});
  }
};
</script>
<style scoped lang="less">
.filter {
  margin-bottom: 30px;
}
.yi-content {
  overflow: hidden;
}
</style>