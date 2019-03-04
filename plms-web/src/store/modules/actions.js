// 可以进行异步操作，如果需要改变states，则必须通过commit调用mutations
import {formatDate} from './../../utils/date'
import {removeToken, removeUserId} from '../../utils/authc'
import * as TYPES from './mutation-types'
import qs from 'qs'
import hexsha1 from './../../../static/js/hex-sha1'

export default {
  // 加密密码
  encryptPassword ({commit}, psd) {
    return hexsha1.hex_sha1(psd)
  },

  // login登录
  async login ({commit}, payload) {
    let Vue = payload.vue
    delete payload.vue
    let result = await Vue.$http.post(Vue.getData('LOGIN_URL'), qs.stringify(payload))
    if (result.result === '1') {
      // 登录成功，更新用户信息
      commit(TYPES.ADD_USER_LOGIN_INFO, result.data)
      return {
        result: '1'
      }
    } else {
      return {
        result: '0',
        data: result.data
      }
    }
  },

  // 退出登录
  logout ({commit}, payload) {
    let Vue = payload.vue
    delete payload.vue
    Vue.$http.get(Vue.getData('LOGOUT_URL')).then(res => {
      if (res.result === '1') {
        removeToken()
        removeUserId()
        window.location.reload()
        Vue.$router.push({name: 'Login'})
      }
    })
  },

  // 格式化时间
  formatDate ({commit}, payload) {
    let date = payload.date
    let dft = payload.dft
    return formatDate(date, dft)
  }
}
