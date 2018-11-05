<template>
  <div class="components-container">
    <div class="info">UE编辑器示例<br>需要使用编辑器时，调用UE公共组件即可。可设置填充内容defaultMsg，配置信息config(宽度和高度等)，可调用组件中获取内容的方法。</div>
    <button @click="getUEContent()">获取内容</button>
    <div class="editor-container">
      <UE :defaultMsg=defaultMsg :config=config ref="ue"></UE>
    </div>
  </div>
</template>

<script>
import UE from '../components/Ueditor.vue'
export default {
  name: 'TestUe',
  components: {UE},
  data () {
    return {
      defaultMsg: '这里是UE测试',
      config: {
        initialFrameWidth: 600,
        initialFrameHeight: 350,
        toolbars: [
          ['fullscreen', 'indent', 'simpleupload', 'insertimage', 'source', 'undo', 'redo', 'bold']
        ]
      }
    }
  },
  methods: {
    getUEContent () {
      let content = this.$refs.ue.getUEContent()
      console.log(content)
    }
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
