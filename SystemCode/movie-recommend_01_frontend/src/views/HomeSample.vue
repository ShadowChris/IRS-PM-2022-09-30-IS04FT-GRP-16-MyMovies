<template>
  <div class="box">
    <div class="right">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item style="padding: 10px 0 2px 10px; font-size: 1.5em;">Home</el-breadcrumb-item>
        <el-breadcrumb-item  style="padding: 15px 0 2px 0; font-size: 1.1em">User Information</el-breadcrumb-item>
      </el-breadcrumb>
      <div class="videos">
        <el-main class="show">
          <div class="basic">
            <div class="card11">
              <el-col :span="4" :offset="1">
                <div class="demo-basic--circle" style="margin-top: 5%">
                  <div class="block" style="width: 100%;height: 100%;"><el-avatar :size="60" :src="user['logoimage']"></el-avatar></div>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="sub-title" style="vertical-align: middle">
                  <h2>{{ user['userName'] }}</h2>
                </div>
              </el-col>
              <el-col :span="2" :offset="6">
                <el-button style="margin-top: 30%; margin-left: 200%;color: #fffa12" icon="el-icon-edit" type="text" @click="$router.push('/AdminDetails')" >修改</el-button>

              </el-col>
            </div>
            <div class="card12">
              <el-row :gutter="20" style="padding-top: 10px">
                <el-col :span="14" style="padding-left: 8%"><div class="grid-content bg-purple" style="display: flex;align-items: center;">
                  <i class="el-icon-user"></i>
                  <h3>&nbsp;Name:&nbsp;</h3>
                  <span>{{ user['real_name'] }}</span>
                </div></el-col>
                <el-col :span="10"><div class="grid-content bg-purple" style="display: flex;align-items: center;">
                  <i class="el-icon-female"></i>
                  <i class="el-icon-male"></i>
                  <h3>&nbsp;Sex:&nbsp;</h3>
                  <span>{{ user['sex'] }}</span>
                </div></el-col>
              </el-row>
              <el-row :gutter="20">
                <el-col :span="24" style="padding-left: 8%"><div class="grid-content bg-purple" style="display: flex;align-items: center;">
                  <i class="el-icon-position"></i>
                  <h3>&nbsp;Email:&nbsp;</h3>
                  <span>{{ user['email'] }}</span>
                </div></el-col>
              </el-row>
              <el-row :gutter="20">
                <el-col :span="24" style="padding-left: 8%"><div class="grid-content bg-purple" style="display: flex;align-items: center;">
                  <i class="el-icon-phone-outline"></i>
                  <h3>&nbsp;Phone:&nbsp;</h3>
                  <span>{{ user['mobile'] }}</span>
                </div></el-col>
              </el-row>
              <el-row :gutter="20">
                <el-col :span="24" style="padding-left: 8%"><div class="grid-content bg-purple" style="display: flex;align-items: center;">
                  <i class="el-icon-phone-outline"></i>
                  <h3>&nbsp;Phone:&nbsp;</h3>
                  <span>{{ user['phone'] }}</span>
                </div></el-col>
              </el-row>
            </div>
          </div>
          <div class="psw">
<!--              <span class="demonstration">Click 指示器触发</span>-->
              <el-carousel trigger="click" height="350px">
                <el-carousel-item v-for="item in urls" :key="item">
<!--                  <img :src="item.u">-->
                  <img style="width: 100%;height: auto;margin-top: 0" :src="item">
<!--                  <h3 class="small">{{ item }}</h3>-->
                </el-carousel-item>
              </el-carousel>
          </div>

        </el-main>
        <el-main class="infom">
<!--          <div class="card1" @click="imginto('fall')">-->
<!--&lt;!&ndash;            <img src="../assets/diedao.png">&ndash;&gt;-->
<!--            <div style="padding-top: 16.5%">-->
<!--              <span style="color: white">跌倒</span>-->
<!--            </div>-->
<!--          </div>-->
<!--          <div class="card2" @click="imginto('activity')">-->
<!--&lt;!&ndash;            <img src="../assets/jiaotan.png">&ndash;&gt;-->
<!--            <div style="padding-top: 10%">-->
<!--              <span style="color: white">交互</span>-->
<!--            </div>-->
<!--          </div>-->
<!--          <div class="card3" @click="imginto('fence')">-->
<!--&lt;!&ndash;            <img src="../assets/moshengrenruqin.png">&ndash;&gt;-->
<!--            <div style="padding-top: 10%">-->
<!--              <span style="color: white">入侵</span>-->
<!--            </div>-->
<!--          </div>-->
<!--          <div class="card4" @click="imginto('strangers')">-->
<!--&lt;!&ndash;            <img src="../assets/shequjingqing_moshengrenyichangzengjia.png">&ndash;&gt;-->
<!--            <div style="padding-top: 10%">-->
<!--              <span style="color: white">陌生人</span>-->
<!--            </div>-->
<!--          </div>-->
<!--          <div class="card5" @click="imginto('smile')">-->
<!--&lt;!&ndash;            <img src="../assets/zu1783.png">&ndash;&gt;-->
<!--            <div style="padding-top: 10%">-->
<!--              <span style="color: white">表情</span>-->
<!--            </div>-->
<!--          </div>-->
        </el-main>
      </div>
      <div class="tip">
        <el-footer>Copyright &nbsp; 2022 &nbsp; ISS Group 14</el-footer>
      </div>
    </div>
  </div>
</template>



<script>
export default {
  name: "HomeInform",

  data () {
    return {
      url: 'http://192.168.159.128:5000/',
      circleUrl: "https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",
      squareUrl: "https://cube.elemecdn.com/9/c2/f0ee8a3c7c9638a54940382568c9dpng.png",
      sizeList: ["large", "medium", "small"],
      user: [],

      urls: [
        require('../assets/carousel1.png'),
        require('../assets/carousel2.png'),
        require('../assets/carousel3.png'),
        require('../assets/carousel4.png'),
      ],
    }
  },
  created() {

    if(sessionStorage.getItem("user") != null)
    //获取登录的用户信息
    this.user = JSON.parse(sessionStorage.getItem("user"))

  },
  methods:{
    //进入截图界面
    imginto(name) {
      console.log('dsad')
      this.$router.push({
        path: `/Shoot/${name}`
      });
    },

    //进入修改界面
    goDetail(){
      this.$router.push({
        path: `/AdminDetails`
      });
    },
  },
}
</script>

<style scoped>
.box{
  width: 100%;
  height: 100%;
  /*background-color: #766d17;*/
  display: flex;
}
.right{
  width: 100%;
  height: 660px;
  background-color: #41296f;
  /*margin-right:0;*/
  margin: 53px 0 0 0;
  /*z-index: 1;*/
}
.videos{
  width: 100%;
  height: 100%;
}
.show{
  width: 100%;
  height: 60%;
  background-color: #ffffff;
  display: flex;
}
.infom{
  display: flex;
  height: 40%;
  width: 100%;
  background-color: #ffffff;
  text-align: center;
  padding: 20px;
  /*background: url('../assets/CCTV1.png');*/
  /*background-size: cover;*/
}
.basic{
  width: 50%;
  height: 100%;
  background-color:#BF9130;
  margin-right: 10px;
  border-radius: 10px;
}
.psw{
  width: 50%;
  height: 100%;
  margin-left: 10px;
  /*background-color: burlywood;*/
}
.card11{
  width: 100%;
  height: 20%;
}
.card12{
  width: 100%;
  height: 80%;
  background-color: #6D89D5;
  border-radius: 0 0 10px 10px;
}
.card1{
  width: 20%;
  height: 99%;
  margin: 0 5px;
  background-color: #226e90;
  border: 1px solid #ffffff;
  border-radius: 30px;
}
.card1:hover{
  box-shadow: 0px 15px 15px rgba(0, 0, 0, 0.3);
}
.card2{
  width: 20%;
  height: 99%;
  margin: 0 5px;
  background-color: #226e90;
  border: 1px solid #ffffff;
  border-radius: 30px;
}
.card2:hover{
  box-shadow: 0px 15px 15px rgba(0, 0, 0, 0.3);
}
.card3{
  width: 20%;
  height: 99%;
  margin: 0 5px;
  background-color: #226e90;
  border: 1px solid #ffffff;
  border-radius: 30px;
}
.card3:hover{
  box-shadow: 0px 15px 15px rgba(0, 0, 0, 0.3);
}
.card4{
  width: 20%;
  height: 99%;
  margin: 0 5px;
  background-color: #226e90;
  border: 1px solid #ffffff;
  border-radius: 30px;
}
.card4:hover{
  box-shadow: 0px 15px 15px rgba(0, 0, 0, 0.3);
}
.card5{
  width: 20%;
  height: 99%;
  margin: 0 5px;
  background-color: #226e90;
  border: 1px solid #ffffff;
  border-radius: 30px;
}
.card5:hover{
  box-shadow: 0px 15px 15px rgba(0, 0, 0, 0.3);
}
.tip{
  height: auto;
  width: 100%;
  /*background-color: #ffb352;*/
  text-align: center;
  padding-top: 20px;
}
.el-main img{
  width: 50%;
  height: auto;
  margin-top: 10%;
}

</style>

<style>
span.el-breadcrumb__inner {
  color: #ffffff;
}
/*.el-carousel__item, .el-carousel__mask {*/
/*  height: 100%;*/
/*  top: 0!important;*/
/*  bottom: 30px;*/
/*  left: 0;*/
/*  position: absolute;*/
/*}*/
</style>

