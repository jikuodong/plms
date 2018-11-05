import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/login/Login'
import Layout from '@/views/login/Layout'
import TestUe from '@/views/TestUe'
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
      component: TestUe
    },
    {
      path: '/Layout',
      name: 'Layout',
      component: Layout
    }
  ]
})
