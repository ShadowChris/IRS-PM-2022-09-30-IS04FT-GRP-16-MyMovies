<template>
  <div id="zong">
    <div id="backimg"></div>
    <div class="card">
      <div class="box11">
        Login
      </div>
      <hr>
      <div class="box31">
        No account, click <router-link id="Register" to="/Register">Register</router-link>
<!--        &nbsp;-->
      </div>
      <div class="box21">
        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" id="block" :label-position="labelPosition" >
          <el-form-item label="mobile" prop="mobile" id="ei">
            <el-input prefix-icon="el-icon-user-solid" v-model="ruleForm.mobile"></el-input>
          </el-form-item>
          <el-form-item label="password" prop="Password" id="eis">
            <el-input prefix-icon="el-icon-key" type="password" v-model="ruleForm.Password" autocomplete="off"></el-input>
          </el-form-item>
        </el-form>
        <el-row :gutter="20">
          <div class="butbox">
            <el-col :span="8" :offset="8"><el-button type="primary" @click="submitForm('ruleForm')">login</el-button></el-col>
            <el-col :span="8"><el-button @click="resetForm('ruleForm')">reset</el-button></el-col>
          </div>
        </el-row>
      </div>
    </div>
    <!--
    http://10.13.1.7:8081/login
    -->
  </div>
</template>

<script>
// import Vue from 'vue'
// import {Input,Button,Divider} from 'element-ui'
// import axios from 'axios'
// import * as qs from 'qs'
// Vue.use(Input)
// Vue.use(Button)
//
// Vue.use(Divider)

import axios from "axios";
import global_variable from "@/utils/global_variable";

export default {
  name: 'Login',
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please enter password'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass');
        }
        // if(!/^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$)([^\u4e00-\u9fa5\s]){9,16}$/.test(value)) {
        //   callback(new Error('Please enter 10-16 English letters, numbers or symbols (except spaces), ' +
        //       'and include at least two types of letters, numbers and punctuation marks'))
        //
        // }
        // callback();
      }
    };

    return {
      labelPosition:'right',
      userToken: '',
      ruleForm: {
        Password: '',
        mobile: '',
      },
      zhud:false,
      loading:false,
      rules: {
        Password: [
          { validator: validatePass, trigger: 'blur' }
        ]
      }
    };
  },
  methods: {

    getUser(){
      axios.post(global_variable.goURL + '/login', {
        mobile:this.ruleForm.mobile,
        passwd: this.ruleForm.Password
      }).then(res => {
        console.log(res)
        if(res.status == 200){
          console.log("Login-Infor：")
          console.log(res)
          if(res.data.code == 200){
            this.$message.success("Successfully")
            // sessionStorage.setItem("user", JSON.stringify(res.data.data.user))
            // console.log(res.headers)
            this.$router.replace("/Home")
            // var user = JSON.parse(sessionStorage.getItem("user"))
            // console.log(user)
          } else {
            this.$message.error("Error!")
          }
        }else {
          this.$message.error("Network Error")
        }
      })


    },
    submitForm(formName) {

      this.$refs[formName].validate((valid) => {
        if (valid) {

          this.getUser();

        } else {
          console.log('error submit!!');
          return false;
        }
      });

    },


    resetForm(formName) {
      // this.$refs[formName].resetFields();
    }
  }
}
</script>

<style scoped>
#zong{
  width: 100%;
  height: 710px;
  position: absolute;
  background-color: rgba(255, 255, 255, 0.2);
}
#backimg {
  background: url('../assets/login.png');
  /*background-color: rgba(255, 255, 255, 0.2);*/
  width: 100%;
  height: 100%;
  /*position: absolute;*/
  /*z-index: -1;*/
  background-size: cover;
  top: 0;
  left: 0;
}
.box11{
  width: 100%;
  height: 30%;
  text-align: center;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 2rem;
  color: #ececec;
}
.box21{
  width: 100%;
  height: 70%;
}
.butbox{
  width: 100%;
  height: 50%;
}
.box31{
  padding-right: 1rem;
  text-align: right;
  color: #ececec;
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
  height:70%;
  margin:auto;
  background-color: rgba(0, 0, 0, 0.5);
  border-radius:40px;
}
#block{
  text-align:center;
  height: 50%;
}

.box21 .el-form-item__label{
  color: #ececec!important;
}

#ei{
  margin: 5% 15% 10% 5%;
}
#eis{
  margin: 10% 15% 10% 5%;
}
#but{
  margin: 15% 25% 10% 5%!important;
}
</style>
<style>

.box21 .el-form-item__label{
  color: #ececec !important;
}
</style>
