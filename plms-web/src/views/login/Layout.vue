<template>
  <div class="hello">
    <h1>首页</h1>
    <div @click="addUserInfo">
      <button>添加信息</button>
      <Slider v-model="value" range></Slider>
    </div>
  </div>
</template>

<script>
import qs from 'qs'
export default {
  name: 'HelloWorld',
  data () {
    return {
    }
  },
  methods: {
    addUserInfo () {
      let payload = {
        userName: '123324r3432'
      }
      // 请求后台数据
      this.$http.post('/user/addUserInfo1', qs.stringify(payload)).then(suc => {
        console.log(suc.result)
        console.log(suc)
      })
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }
  ul {
    list-style-type: none;
    padding: 0;
  }
  li {
    display: inline-block;
    margin: 0 10px;
  }
  a {
    color: #42b983;
  }
</style>
