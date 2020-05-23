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
      <el-table-column prop="blogId" label="博客id" width="120"></el-table-column>
      <el-table-column prop="bloggerId" label="博主id" width="120"></el-table-column>
      <el-table-column prop="title" label="标题" width="120"></el-table-column>
      <!-- <el-table-column prop="content" label="内容" width="460" class="yi-content"></el-table-column> -->
      <el-table-column prop="createTime" label="创建时间" width="120"></el-table-column>
      <el-table-column prop="modifyTime" label="修改时间" width="120"></el-table-column>
      <el-table-column prop="blogType" label="博客类型" width="120"></el-table-column>
      <el-table-column label="操作" width="100">
        <template slot-scope="scope">
          <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
          <el-button @click="editorClick(scope.row)" type="text" size="small">编辑</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin-top: 20px">
      <el-button @click="toggleSelection()">取消选择</el-button>
      <el-button @click="multiplyDelete()">批量删除</el-button>
    </div>
  </div>
</template>

<script>
import {
  getAllBlogByPageNum,
  delMultiplyBlog,
  findBlogByTitle
} from "../../network/blog";
import { log } from "util";
export default {
  name: "yiMain",
  data() {
    return {
      tableData: [
        {
          blogId: "",
          bloggerId: "",
          title: "",
          content: "",
          createTime: "",
          modifyTime: "",
          blogType: ""
        }
      ],
      // 选中的数组
      multipleSelection: [],
      // 存放博客对象
      blogsMap: new Map(),
      // 当前页数
      currentPage: 1,
      input: ""
    };
  },
  methods: {
    editorClick(row) {
      // 编辑
    },
    handleClick(row) {
      // 查看
      window.location.href = "http://localhost:3000/article/" + row.blogId;
      console.log(row);
    },
    queryAll() {
      // 获得第一页博文
      getAllBlogByPageNum(1).then(res => {
        // 指向当前的tableData
        this.tableData = res.data;
        // 把博文放入map集合
        this.blogsMap.set(1, res);
      });
    },
    multiplyDelete() {
      let delArr = this.multipleSelection.map(item => {
        return item.blogId;
      });
      delMultiplyBlog(delArr);
      setTimeout(() => {
        this.queryAll();
      }, 500);
    },
    change() {
      if (this.input === "") {
      } else {
        this.tableData = findBlogByTitle(this.input).data;
      }
    },
    toggleSelection(rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.$refs.multipleTable.clearSelection();
      }
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
      console.log(this.multipleSelection);
    }
  },
  created() {
    this.queryAll();
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