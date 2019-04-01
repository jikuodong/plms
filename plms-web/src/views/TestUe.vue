<template>
  <div class="components-container">
    {{context}}
  </div>
</template>

<script>
import Stomp from 'stompjs' // 可以npm安装，也可以直接下载stomp.js引入
import {MQ_SERVICE, MQ_USERNAME, MQ_PASSWORD} from '../utils/rabbit'
export default {
  name: 'rabbitMQ',
  data () {
    return {
      context: '',
      client: Stomp.client(MQ_SERVICE) // 使用client 直接创建Stomp 连接
    }
  },
  methods: {
    connect () {
      // 用户名、密码、连接成功回调、失败回调
      this.client.connect(MQ_USERNAME, MQ_PASSWORD, this.onConnected, this.onFailed, '/')
      // 关闭心跳，SockJs不支持
      this.client.heartbeat.outgoing = 20000
      this.client.heartbeat.incoming = 0
    },
    onConnected (frame) {
      console.log('Connected: ' + frame)
      let queue = '/queue/1111111111111'
      this.client.subscribe(queue, this.responseCallBack)
    },
    onFailed (frame) {
      console.log('Failed: ' + frame)
    },
    responseCallBack (frame) {
      console.log('responseCallback msg=>' + frame.body)
      this.context += frame.body
    }
  },
  created () {
    this.connect()
  }
}
</script>

<style scoped>
  .info{
    border-radius: 10px;
    line-height: 20px;
    padding: 10px;
    margin: 10px;
    background-color: #ffffff;
  }
</style>
