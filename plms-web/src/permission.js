import router from './router'
import store from './store/global-store'
import {ADD_ASYNC_ROUTERS} from './store/modules/mutation-types'
import {getToken, removeToken, removeUserId} from './utils/authc'
import axios from 'axios'

// 定义将字符串转换为组件的方法
const _import = require('./router/_import_' + process.env.NODE_ENV)
// 白名单，无需权限即可访问
const whiteList = ['/login']
// 存放获取到的后台路由
let asyncRouters = store.getters.asyncRouters
router.beforeEach((to, from, next) => {
  // 判断是否存在token
  if (getToken()) {
    if (to.path === '/login') { // 存在token，且路由是登录页，则跳转首页
      next({path: '/'})
    } else {
      if (!asyncRouters) {
        let instance = axios.create({
          baseURL: process.env.API_BASE_URL,
          headers: {'Authorization': getToken()}
        })
        // 没有获取到后台的路由，则进行重新获取
        instance.get('/permission/getAsyncRouter').then(res => {
          routerGo(to, next, res.data.data.children)
        }).catch(err => {
          console.log(err)
          // 如果获取失败，则返回登录页
          removeToken()
          removeUserId()
          next({name: 'Login'})
          window.location.reload()
        })
      } else {
        // 如果未匹配到路由，就匹配上级路由
        if (to.matched.length === 0) {
          // 如果上级也未匹配到路由则跳转首页
          from.name ? next({ name: from.name }) : next({ name: 'Index' })
        } else {
          // 如果匹配到正确跳转
          next()
        }
      }
    }
  } else {
    // 如果在白名单，直接放行，否则跳转到登录页
    if (whiteList.indexOf(to.path) !== -1) {
      next()
    } else {
      next('/login')
    }
  }
})

function routerGo (to, next, data) {
  asyncRouters = filterAsyncRouter(data) // 过滤路由
  // 添加到顶层路由中
  let topRouter = [{
    path: '/',
    name: 'Index',
    component: () => import('@/views/Layout'),
    meta: {
      title: 'XXXX后台管理系统'
    },
    children: asyncRouters
  }]
  router.addRoutes(topRouter) // 动态添加路由
  store.commit(ADD_ASYNC_ROUTERS, asyncRouters) // 将路由数据传递给全局变量，做侧边栏菜单渲染工作
  next({ ...to, replace: true }) // hack方法 确保addRoutes已完成 ,set the replace: true so the navigation will not leave a history record
}

// 过滤路由，将字符串转换为组件对象
function filterAsyncRouter (asyncRouterMap) {
  const filterRouters = asyncRouterMap.filter(route => {
    if (route.component) {
      route.component = _import(route.component)
    }
    if (route.children && route.children.length) {
      route.children = filterAsyncRouter(route.children)
    }
    return true
  })
  return filterRouters
}
