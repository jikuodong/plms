<template>
  <div class="components-container">
    <Button @click="ceshi">测试</Button>
  </div>
</template>

<script>
export default {
  name: 'TestUe',
  data () {
    return {}
  },
  methods: {
    ceshi () {
      let payload = {
        vue: this
      }
      this.$store.dispatch('ceshi', payload).then(res => {
        if (res.result === '1') {
          alert('成功！')
        }
      })
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
