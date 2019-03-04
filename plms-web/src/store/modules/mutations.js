// 这里要注意不要在mutations里面进行异步操作，只是用来改变state的值
import * as TYPES from './mutation-types'
import {setToken} from '../../utils/authc'

export default {
  [TYPES.ADD_USER_LOGIN_INFO] (state, payload) {
    setToken(payload.accessToken)
  }
}
