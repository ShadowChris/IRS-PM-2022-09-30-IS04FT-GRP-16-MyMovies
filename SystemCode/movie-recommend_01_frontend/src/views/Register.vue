<template>
  <div id="zong">
    <div id="backimg"></div>
    <div class="card">
      <div class="box12">
        Register
      </div>
      <hr>
      <div class="box32">
        Already have an account, click <router-link id="Register" to="/login">Login</router-link>
      </div>
      <div class="box22">
        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" id="block" :label-position="labelPosition" >

          <el-form-item label="mobile" prop="phone" id="eisss">
            <el-input prefix-icon="el-icon-phone"  v-model="ruleForm.mobile"></el-input>
          </el-form-item>
          <el-form-item label="password" prop="passwd" id="eis">
            <el-input prefix-icon="el-icon-key" type="password" v-model="ruleForm.passwd" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="confirm password" prop="checkPass" id="eiss">
            <el-input prefix-icon="el-icon-key" type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
          </el-form-item>
          <el-form-item label="code" prop="code" id="e">
            <el-input prefix-icon="el-icon-user-solid"  v-model="ruleForm.code"></el-input>
          </el-form-item>
          <el-row :gutter="20">
            <div class="butbox">
              <el-col :span="8" :offset="8"><el-button type="primary" @click="submitForm('ruleForm')">register</el-button></el-col>
              <el-col :span="8"><el-button @click="resetForm('ruleForm')">reset</el-button></el-col>
            </div>
          </el-row>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>

import axios from "axios";
import global_variable from "@/utils/global_variable";

const TIME_COUNT = 60 // 设置一个全局的倒计时的时间
export default {
  name: 'Register',
  data() {
    // var checkMail = (rule, value, callback) => {
    //   const mailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/
    //   if (!value) {
    //     return callback(new Error('邮箱不能为空'));
    //   }
    //   setTimeout(() => {
    //     if (mailReg.test(value)) {
    //       callback()
    //     } else {
    //       callback(new Error('请输入正确的邮箱格式'))
    //     }
    //   }, 100)
    // };
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('please enter password'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass');
        }
      //   if(!/^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$)([^\u4e00-\u9fa5\s]){10,16}$/.test(value)) {
      //     callback(new Error('Please enter 10-16 English letters, numbers or symbols (except spaces), ' +
      //         'and include at least two types of letters, numbers and punctuation marks'))
      //
      //   }
      //   callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('please enter password again'));
      } else if (value !== this.ruleForm.passwd) {
        callback(new Error('The passwords entered twice do not match!'));
      } else {
        callback();
      }
    };
    var checkPhone = (rule, value, callback) => {
      const regMobile = /^(0|86|17951)?(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[57])[0-9]{8}$/
      if (!value) {
        return callback(new Error('Number cannot be empty'));
      }
      setTimeout(() => {
        if (regMobile.test(value)) {
          callback()
        } else {
          callback(new Error('Please enter the correct number format'))
        }
      }, 100)
    };

    return {
      labelPosition:'right',
      ruleForm: {
        mobile: "",
        passwd: "",
        checkPass: "",
        code: "123456"
      },
      rules: {
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ],
        // mail: [
        //   { validator: checkMail, trigger: 'blur' }
        // ],
        mobile: [
          { validator:checkPhone, trigger: 'blur'}
        ],
      }
    };
  },
  methods: {
    getCode () {
      // let _this = this
      // if (this.ruleForm.mail === '') {
      //   _this.$message.error('请先输入邮箱再点击获取验证码')
      // } else {
      //   axios({
      //     method: 'post',
      //     url: this.Host.BASE_URL  + 'sendCheckCode',
      //     data: {
      //       'email': this.ruleForm.mail
      //     }
      //   }).then(res=>{
      //     sessionStorage.setItem('checkCode', md5(res.data))  // 这里我没用redis做缓存，用的浏览器sessionStorage+md5加密存下来的
      //     // console.log(res)
      //   })
      //   // 验证码倒计时
      //   if (!this.timer) {
      //     this.count = TIME_COUNT
      //     this.show = false
      //     this.timer = setInterval(() => {
      //       if (this.count > 0 && this.count <= TIME_COUNT) {
      //         this.count--
      //       } else {
      //         this.show = true
      //         clearInterval(this.timer)
      //         this.timer = null
      //       }
      //     }, 1000)
      //   }
      // }
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
              this.$http({
                method: 'post',
                url: global_variable.goURL + '/signup/mobile',
                data: {
                  mobile:this.ruleForm.mobile,
                  passwd:this.ruleForm.passwd,
                  code: this.ruleForm.code
                }
              }).then(res=>{
                console.log(res)
                if(res.data.code == 200){
                  this.$router.replace("/login");
                  this.$message.success('Successfully');
                }
              })
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },

    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>
#zong{
  width: 100%;
  height: 710px;
  position: absolute;
  /*background-color: rgba(255, 255, 255, 0.2);*/
}
#backimg {
  background: url('../assets/login.png');
  width: 100%;
  height: 100%;
  position: absolute;
  z-index: -1;
  background-size: cover;
  top: 0;
  left: 0;
}
.box12{
  width: 100%;
  height: 10%;
  text-align: center;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 2rem;
  color: #ececec;
}
.box22{
  width: 100%;
  height: 90%;
  color: #ececec;
}
.box32{
  padding-right: 1rem;
  text-align: right;
  color: #ececec;
}
.butbox{
  width: 100%;
  height: 50%;
}
#Register{
  color: #409EFF;
}
a{
  text-decoraction: none;
}
.router-link-active {
  text-decoration: none;
}
.card{
  position: absolute;
  top:0;
  left:0;
  bottom:0;
  right:0;
  width:30%;
  height:95%;
  margin:auto;
  background-color: rgba(0, 0, 0, 0.5);
  border-radius:40px;
}
#block{
  text-align:center;
  height: 50%;
}

#e{
  margin: 2% 15% 4% 5%;
}
#es{
  margin: 7% 15% 4% 5%;
}
#ei{
  margin: 7% 15% 4% 5%;
}
/*#ei{*/
/*  margin: 2% 15% 5% 5%;*/
/*}*/
#eis{
  margin: 7% 15% 4% 5%;
}
#eiss{
  margin: 7% 15% 4% 5%;
}
#eisss{
  margin: 7% 15% 2% 5%;
}
#eisssss{
  width: 100%;
  height: auto;
  margin: 0 15% 10% 5%;
}

#but{
  margin: 5% 25% 12% 5%!important;
}
</style>
<style>
/*element.style {*/
/*  padding-left: 0;*/
/*  padding-right: 35%;*/
/*}*/
.box22 .el-form-item__label{
  color: #ececec !important;
}
</style>
