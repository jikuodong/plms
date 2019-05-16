import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/views/login/Login'
Vue.use(Router)
// 公共路由，无需权限
export const publicRouterMap = [
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/',
    name: 'Index',
    component: () => import('@/views/Layout'),
    meta: {
      title: 'XXXX后台管理系统'
    }
  }
]
export default new Router({
  // 跳转url没有#号
  mode: 'history',
  routes: publicRouterMap
})
