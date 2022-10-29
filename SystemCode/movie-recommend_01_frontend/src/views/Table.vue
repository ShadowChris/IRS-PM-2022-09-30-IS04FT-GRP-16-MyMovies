<template>

  <div id="psgBarChart" ref="psgBarChart"></div>

</template>

<script>
import global_variable from "@/utils/global_variable";
import axios from "axios";
import Global_variable from "@/utils/global_variable";

export default {

  data() {
    return {
      // tableData: [{
      //   Name: '基于内容的推荐算法',
      //   MSE: '0.96124462',
      //   RMSE: '0.98043083'
      // }, {
      //   Name: '协同过滤推荐算法',
      //   MSE: '1.255092442',
      //   RMSE: '1.12030908'
      // }]
      tableData: []
    }
  },
  mounted() {
    this.getModelPerformance()
    this.updateChart()
    // console.log(this.getList('MSE'))
  },
  methods: {
    updateChart() {
      // 基于准备好的dom，初始化echarts实例
      let myChart = this.$echarts.init(document.getElementById('psgBarChart'));

      // 指定图表的配置项和数据
      let option = {
        title: {
          text: 'Recommendation Performance'
        },
        tooltip: {},
        legend: {
          data: ['MSE', 'RMSE']
        },
        xAxis: {
          data: ['Content Based Model', 'Collaborative Filtering Model']
        },
        yAxis: {},
        series: [
          {
            name: 'MSE',
            type: 'bar',
            data: this.getTableDataList('MSE')
          },
          {
            name: 'RMSE',
            type: 'bar',
            data: this.getTableDataList('RMSE')
          }
        ]
      };

      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
    },
    getTableDataList(index) {
      var arr = new Array()
      for (let i in this.tableData) {
        let item = this.tableData[i][index]
        arr.push(item)
      }
      return arr
    },
    getModelPerformance() {
      axios.get(Global_variable.springURL + "/recommend/getPerformance").then(res => {
        if (res && res.status === 200) {
          this.tableData = res.data.performance
        }
      })
    }
  }

}

</script>

<style >
#psgBarChart {
  margin-top: 100px;
  width: 1200px;
  height: 500px;
  background-color: pink;
}
</style>
