<template>
  <div class="login-style">
    <div class="login-content" @keyup.13="login">
      <Divider style="color: #fff">个人生活管理系统</Divider>
      <Card class="login-card">
        <Input v-model="userName" placeholder="用户名/手机号" style="width: 80%" size="large" @on-focus="cancelError">
          <Icon type="md-person" slot="prefix" size="20"/>
        </Input><br>
        <Input v-model="password" placeholder="登录密码" style="width: 80%;margin-top: 20px" type="password" size="large" @on-focus="cancelError">
          <Icon type="md-lock" slot="prefix" size="20"/>
        </Input><br>
        <!--<Input placeholder="右侧验证码" style="width: 50%;margin-top: 20px" type="password">-->
          <!--<Icon type="md-lock" slot="prefix" size="20"/>-->
        <!--</Input><br>-->
        <div class="error-text" v-if="isShowError">
          <Icon type="md-close-circle" size="20" style="color: #dc3c00" />
          <span>{{errorText}}</span><br>
        </div>
        <div class="login-btn">
          <Button type="primary" style="width: 70%" @click="login" >登录</Button>
        </div>
      </Card>
    </div>
  </div>
</template>

<script>
export default {
  name: 'login',
  data () {
    return {
      userName: '',
      password: '',
      errorText: '',
      isShowError: false
    }
  },
  methods: {
    // login登录
    async login () {
      if (this.validateInfo()) {
        // 进入系统首页
        this.$router.push({name: 'Index'})
      } else {
        // 给出错误提示
        this.errorText = '用户名密码不正确'
        this.isShowError = true
      }
    },
    // 校验用户名、密码
    validateInfo () {
      if (this.userName === '') {
        this.errorText = '请输入正确的用户名或手机号'
        this.isShowError = true
        return false
      } else if (this.password === '') {
        this.errorText = '请输入密码'
        this.isShowError = true
        return false
      }
      return true
    },
    cancelError () {
      this.isShowError = false
    }
  }
}
</script>

<style scoped lang="stylus" rel="stylesheet/stylus">
  .login-style
    width 100%
    height 100%
    background url("../../assets/wpc-bg.png")
    background-repeat no-repeat
    background-size 100% 100%
  .login-content
    position absolute
    width 30%
    height 35%
    top 25%
    left 35%
  .login-card
    position relative
    margin-top 8%
    padding 20px 20px
  .error-text
    display inline-block
    text-align left
    width 80%
    margin-top 10px
    padding-left 6px
    color #b74d46
    background-color #fff0f0
    border 1px solid #ffd2d2
    line-height 26px
    font-size 12px
  .login-btn
    padding-top 10%
</style>
