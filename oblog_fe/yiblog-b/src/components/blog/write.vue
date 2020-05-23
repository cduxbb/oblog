<template>
  <div id="editor">
    <mavon-editor style="height: 100%" @save="save"></mavon-editor>
    <!-- Form -->
    <el-button type="text" @click="dialogFormVisible = true">
      <el-button type="primary">提交文章</el-button>
    </el-button>

    <el-dialog title="文章属性" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="文章标题" :label-width="formLabelWidth">
          <el-input v-model="form.title" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="文章标签" :label-width="formLabelWidth">
          <el-input v-model="form.blogType" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="commit()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
// Local Registration
import { mavonEditor } from "mavon-editor";
import { queryBloger } from "../../network/bloger.js";
import { writeBolg } from "../../network/blog";
import "mavon-editor/dist/css/index.css";
export default {
  name: "editor",
  data() {
    return {
      dialogTableVisible: false,
      dialogFormVisible: false,
      form: {
        title: "",
        bloggerId: "",
        content: "",
        blogType: ""
      },
      formLabelWidth: "120px"
    };
  },
  components: {
    mavonEditor
    // or 'mavon-editor': mavonEditor
  },
  methods: {
    save(value, render) {
      this.form.content = render;
    },
    commit() {
      queryBloger(this.$store.state.userName).then(res => {
        this.form.bloggerId = res.data.id;
        console.log(res.data.id);
        console.log(this.form.title);
        console.log(this.form.blogType);
        console.log(this.form.content);
        writeBolg(this.form)
          .then(res => {
            console.log("res status :" + res.data);
            console.log("添加成功");
          })
          .catch(err => {
            console.log("添加失败");
          });
        this.dialogFormVisible = false;
      });
    }
  }
};
</script>
    <style>
#editor {
  margin: auto;
  width: 80%;
  height: 580px;
}
</style> 