<template>
<div id="Home">

  <el-container style="padding-top: 120px; width: 1500px; padding-left: 100px; background-color: #e8e8e8">
    <el-aside>
      </el-aside>
    <el-header style="display: block; width: 1500px">
      <el-row style="margin-left: 500px">
        <el-col :span="25" style="margin-right: 20px; width: 350px"><el-input v-model="input" placeholder="Input to search..."></el-input></el-col>
        <el-col :span="2">
<!--          <el-button icon="el-icon-search" circle @click="this.search">-->
          <el-button type="primary" round icon="el-icon-search" @click="this.search">
          </el-button></el-col>
      </el-row>
    </el-header>

    <el-main>
      <el-row style="alignment: left">
        <el-col :span="8" v-for="(item) in this.movieList" :key="item.id" style="margin: 10px">
          <el-card :body-style="{ padding: '20px' }" shadow="hover">

<!--            <el-popover-->
<!--                placement="top-start"-->
<!--                title="Title"-->
<!--                width="200"-->
<!--                trigger="hover"-->
<!--                :content="item.name">-->
<!--            <img :src="item.url" class="image" slot="reference">-->
<!--            </el-popover>-->
            <div style="padding: 5px; text-align: center">
              <img :src="item.url" class="image" slot="reference" style="width: 174px; height: 256px">
              <div class="bottom clearfix" font-size="5px">
                <router-link id="card-name" :to="'/MovieDetails/' + item.id" :underline="false"
                             style="
                             font-size: 16px;
                             display: block;
                             padding-top: 5px;
                             padding-bottom: 30px;
                             height: 10px;
                             text-decoration: none;
                             font-weight: bold;
                             line-height:15px">
                  {{item.name}}</router-link>
              </div>
              <div class="block">
                <el-rate
                    v-model="item.rating"
                    disabled
                    show-score
                    text-color="#ff9900"
                    score-template="{value}">
                </el-rate>
              </div>
            </div>
          </el-card>

        </el-col>
      </el-row>

    </el-main>
    <el-footer>
      <el-row>
        <div class="block">
          <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              @next-click="getPage"
              :current-page.sync="currentPage"
              :page-size=this.pageSize
              layout="prev, pager, next, jumper"
              :total="this.totalPage">
          </el-pagination>
        </div>
      </el-row>
    </el-footer>


  </el-container>

</div>
</template>

<script>
import axios from "axios";
import global_variable from "@/utils/global_variable";

export default {
  name: "Test",

  data() {
      return {
        input: "",
        colors: ['#99A9BF', '#F7BA2A', '#FF9900'], // 等同于 { 2: '#99A9BF', 4: { value: '#F7BA2A', excluded: true }, 5: '#FF9900' },
        movieList: [],
        currentPage: 1,
        pageSize: 10,
        visible: false,
        totalPage: 0
      }
  },

  methods: {
    showData() {
      console.log(this.input)
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);

    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);


      this.search()
    },
    getPage() {
      axios.post(global_variable.springURL + '/home/queryMovieList', {
        pageNum: this.currentPage,
        pageSize: this.pageSize
      }).then(res => {
        this.movieList = res.data.data.list
        // this.currentPage = res.data.data.pageNum
        // this.pageSize = res.data.data.pageSize
        this.totalPage = res.data.data.total
        console.log(res)
      })
    },

    search(){
      axios.post(global_variable.springURL + '/home/queryMovieList', {
        name:this.input,
        pageNum: this.currentPage,
        pageSize: this.pageSize
      }).then(res => {
        this.movieList = res.data.data.list
        // this.currentPage = res.data.data.pageNum
        // this.pageSize = res.data.data.pageSize
        this.totalPage = res.data.data.total
        console.log(res)
      })
    },
  },

  mounted() {
   this.getPage()
  }
}

</script>

<style>

span{
  width: auto;
  text-align: center;
}

.time {
  font-size: 20px;
  color: #999;
}



.bottom {
  margin-top: 13px;
  line-height: 12px;
}

/*鼠标悬停在标题的效果样式*/
a {
  color: #333333;
  font-weight: bold;
}
a:hover {
  color: #3a91ba;
  font-weight: bold;
}

.image {
  width: 100%;
  display: block;
  /*width: 180px;*/
  /*height: 280px*/
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}

</style>
