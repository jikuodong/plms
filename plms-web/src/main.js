// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
// 引入iview
import iView from 'iview'
import 'iview/dist/styles/iview.css' // 使用 CSS
Vue.use(iView)
// 组织生产环境提示
Vue.config.productionTip = false

/*   *************************************** axios start ********************************* */
const baseUrl = process.env.API_BASE_URL
// 添加请求拦截器
axios.interceptors.request.use(
  config => {
    debugger
    // 在发送请求之前做些什么
    config.headers['Content-Type'] = 'application/x-www-form-urlencoded'
    // `timeout` 指定请求超时的毫秒数(0 表示无超时时间)
    // 如果请求话费了超过 `timeout` 的时间，请求将被中断
    // config.timeout = 2500
    // 每个请求添加前缀
    config.baseURL = baseUrl
    return config
  },
  error => {
    // 对请求错误做些什么
    return Promise.reject(error)
  }
)
// 添加响应拦截器
axios.interceptors.response.use(
  response => {
    // 对响应数据做点什么
    return response.data
  },
  error => {
    // 对响应错误做点什么
    console.log(error.response)
    if (error.response) {
      switch (error.response.status) {
        // 如果状态为401未授权，则清楚登陆token，返回登陆页
        case 401:
          window.location.reload()
          break
        // 如果状态为302（手动退出），则清楚登陆token，返回登陆页
        case 302:

          break
        // 如果状态为500（服务器抛出错误），则清楚登陆token，返回登陆页
        case 500:
          // 服务器抛出错误，返回500页面

          break
      }
    }
    return Promise.reject(error.response.data)
  }
)
// 绑定axios属性
Vue.prototype.$http = axios
/* *************************************** axios end **************************************** */
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
