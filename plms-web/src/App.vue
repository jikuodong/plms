<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style lang="stylus" ref="stylesheet/stylus">
  @import "../static/css/reset.css"
  #app
    font-family 'Avenir', Helvetica, Arial, sans-serif
    /* 让页面字体更清晰 */
    -webkit-font-smoothing antialiased
    -moz-osx-font-smoothing grayscale
    text-align center
    color #2c3e50
    height 100%
</style>
