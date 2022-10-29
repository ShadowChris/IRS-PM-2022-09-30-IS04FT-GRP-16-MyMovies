<template>
  <div id="MovieAdd">
    <el-main style="padding: 0">

      <div v-if="mode" class="detail-title" >
        Entry
      </div>


      <div class="profile-container">
        <el-upload
            class="avatar-uploader"
            action=""
            :http-request="uploadImg"
            :show-file-list="false"
        >
          <el-avatar v-if="logoimage" shape="square" :size="200" :src="logoimage"></el-avatar>
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
        <el-dialog :visible.sync="dialogVisible">
          <img width="100%" :src="dialogImageUrl" alt="">
        </el-dialog>
      </div>
      <div class="container">
        <el-form v-if="mode" ref="form" label-width="80px">

          <el-form-item label="Title">
            <el-input v-model="userName"></el-input>
          </el-form-item>


          <el-row :gutter="10" v-if="mode">
            <el-col :span="12">
              <el-form-item label="Release">
                <el-input v-model="REAL_NAME"></el-input>
              </el-form-item>

              <el-form-item label="id">
                <el-input v-model="id" disabled></el-input>
              </el-form-item>


            </el-col>

            <el-col :span="12">
              <el-form-item label="Director">
                <el-input v-model="EMAIL"></el-input>
              </el-form-item>

              <el-form-item label="Stars">
                <el-input v-model="PHONE"></el-input>
              </el-form-item>


            </el-col>
          </el-row>
          <br>
          <el-col align="center">
            <el-form-item>
              <el-button v-if="mode" type="primary" @click="open">Comfirm</el-button>
            </el-form-item>
          </el-col>
        </el-form>


      </div>
    </el-main>

  </div>
</template>

<script>
import {client, getCurrentDateTime} from "@/utils/oss";

export default {
  name: "MovieAdd",
  data() {




    return {

      dialogImageUrl: '',
      dialogVisible: false,

      id: "",
      userName: "",
      REAL_NAME: "",
      SEX: "",
      EMAIL: "",
      PHONE: "",
      MOBILE: "",
      logoimage: "",
      user: [],

      //1是修改信息，0是修改密码
      mode: 1,
      passwdText: "修改密码"

      // //头像路径
      // profile_photo: "https://lzh-pic.oss-cn-beijing.aliyuncs.com/images/czm/smile_10.jpg"
    };

  },
  created() {
    //从session里拿用户数据
    this.user = JSON.parse(sessionStorage.getItem("user"))

    this.id = this.user["user_id"];
    this.userName = this.user["userName"];
    this.REAL_NAME = this.user["real_name"];
    this.SEX = this.user["sex"];
    this.EMAIL = this.user["email"];
    this.PHONE = this.user["phone"];
    this.MOBILE = this.user["mobile"];
    this.logoimage = this.user["logoimage"];


  },
  methods: {
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {

          this.updatePassword();

        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    open() {
      this.$message('Successfully!!!');
    },




    updateBlog() {
      this.$http
          .put(this.global.baseURL + this.global.adminURL.update, {
            ID: this.id,
            UserName: this.userName,
            REAL_NAME: this.REAL_NAME,
            EMAIL: this.EMAIL,
            SEX: this.SEX,
            PHONE: this.PHONE,
            MOBILE: this.MOBILE,
            logoimage: this.logoimage

          })
          .then(result => {
            // eslint-disable-next-line no-redeclare
            // var result = result.body;
            if (result.status === 200) {
              alert("修改成功！");

              this.user["userName"] = this.userName;
              this.user["real_name"] = this.REAL_NAME;
              this.user["sex"] = this.SEX;
              this.user["email"] = this.EMAIL;
              this.user["phone"] = this.PHONE;
              this.user["mobile"] = this.MOBILE;
              this.user["logoimage"] = this.logoimage;

              sessionStorage.setItem("user", JSON.stringify(this.user))

              this.$router.push("/")
            } else {
              // 失败了
              alert("修改失败！");
            }
          });
    },

    uploadImg(e) {

      let file = e.file // 文件信息
      if (!file) {
        return false
      } else if (!/\.(png|jpg)$/.test(file.name.toLowerCase())) {
        // 格式根据自己需求定义
        this.$message.error('上传格式不正确，请上传png或者jpg格式')
        return false
      }
      let name = 'images/profile_photo/' + getCurrentDateTime() + '.png';
      client.put(name, file)
      client.list().then(res => {
        // console.log(res)
        this.logoimage = 'https://lzh-pic.oss-cn-beijing.aliyuncs.com/' + name;
        // console.log("上传成功：" + this.profile_photo)
        this.$forceUpdate()
      })
    },
  }
}
</script>

<style scoped>
.el-main {
  width: 1500px;
  background-color: #E9EEF3;
  color: #333;
  /*text-align: center;*/
  line-height: 30px;
  margin-top: 50px;
}

.container {
  display: block;
  width: 600px;
  height: 700px;
  padding-top: 100px;
  margin: 0 auto;

}

.avatar-uploader {
  width: 178px;
  height: 178px;
  display: block;
  margin: 0 auto;
}

.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}

.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: grey;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
  border: 3px solid grey;
  border-radius: 20px;

}

.avatar {
  width: 178px;
  height: 178px;
  display: block;
}

.el-form {

}

.el-button {
  width: 100px;
  position: relative;
  right: 30px;
}

.detail-title {
  display: block;
  position: relative;
  width: 300px;
  padding-top: 70px;
  padding-bottom: 50px;
  left: 85px;
  margin: 0 auto;
  /*vertical-align: center;*/
  font-size: 40px;
  font-weight: bold;
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
}

.el-breadcrumb__inner a, .el-breadcrumb__inner.is-link {
  color: #ffffff !important;
}

</style>

<style scoped>
.el-avatar > img {
  position: relative;
  right: 25px;
}

</style>
