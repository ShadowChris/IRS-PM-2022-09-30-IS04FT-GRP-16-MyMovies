<template>

  <div id="MovieDetails">
    <el-container>
      <el-header height="50px"></el-header>
      <el-container style="width:1300px; background-color:#372948" >
        <el-aside width="70%" style="padding-left:50px;padding-right: 30px;">

          <template>
            <div class="slide-content" align="left">
              <p class="count"> {{movie.name}}{{movie.date}}</p>
              <div class="rateAndType">
                <div class="block">
                  <el-rate
                      v-model="value"
                      show-score
                      text-color="#ff9900"
                      score-template="{value}"

                      @change="open">
                  </el-rate>
                </div>
                <el-tag
                    style="margin: 3px"
                    effect="dark"
                >
                  {{movie.genre}}
                </el-tag>
              </div>
              <div id="movie" class="movie-profile">
                <p>Driectors：{{movie.directors}}</p>
                <p>Writters：{{movie.writers}}</p>
                <p>Stars：{{movie.stars}}</p>
                <p>Release：{{movie.releaseTime}}</p>
                <p>Duration：{{movie.time}}</p>
                <p>Intro：{{movie.intro}}</p>
              </div>
            </div>
          </template>

        </el-aside>
        <el-main>
          <div class="海报">
            <div class="top-n slides">

              <img :src="movie.url" class="image">

            </div>

          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>

// import Rate from "@/components/common/Rate";

import ImageDetails from "@/views/Management/ImageDetails";
import axios from "axios";
import global_variable from "@/utils/global_variable";
export default {
  name: 'MoviesDetails',
  // components: {ImageDetails},
  // components: {EditInformation,Rate},
  data () {
    return {
      value: 0,
      movie: {}
    }
  },
  mounted: function () {
    this.loadMovies()
  },
  methods: {
    loadMovies () {
      const _this = this;
      this.$axios.get( global_variable.springURL +'/movie/' + this.$route.params.id).then(resp => {
        console.log(resp.status)
        console.log(resp.data)
        if (resp && resp.status === 200) {
          _this.movie = resp.data.data
          this.value = _this.movie.rating
        }
      })
    },
    open() {
      this.$message({
        message: 'Successfully rated!',
        type: 'success'
      });
    },
    rateMovies(){
      axios.post("http://172.17.147.222:8080/rating/rateAMovie", {
        movieId: this.movie.id,
        rating: this.value,
        userId:"123456"
      }).then(resp => {
        console.log(resp.status)
        console.log(resp.data)
      })
    }
  }
}
</script>

<style>
p {
  color: #3a91ba;
  overflow: hidden;
  display: -webkit-box;
  -webkit-line-clamp: 6;
  -webkit-box-orient: vertical;
}
div.slide-content p.count {
  font-size: 45px;
  margin-top: 20px;
  margin-bottom: 20px;
}
div.slide-content p{
  font-size: 20px;
}
.function img:hover {
  transform: scale(1.2);
}
.function img {
  vertical-align: middle;
}
.function {
  margin-top: 40px;
  margin-bottom: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.function span {
  color: #3a91ba;
  padding-right: 70px;
  vertical-align: middle;
  padding-left: 15px;
}
.main-slide {
  display: flex;
  flex-direction: column;
  align-items: center;
}
/*
.arrows {
  margin-top: 30px;
  padding-right: 60px;
}*/
.arrows img:hover {
  transform: scale(1.2);
}
/*
.icon-arrow-right {
  margin-left: 15px;
}
.icon-arrow-left {
  margin-right: 15px;
}
*/
.rateAndType {
  display: flex;
  align-items: center;
}
</style>
