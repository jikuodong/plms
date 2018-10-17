import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/login/Login'
import Layout from '@/views/login/Layout'

Vue.use(Router)

export default new Router({
  // 跳转url没有#号
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/index',
      name: 'Index',
      component: Layout
    }
  ]
})
