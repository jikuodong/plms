/**
 * token相关操作
 * @author JKD
 * @data 2019/3/4 17:32
 */

const TokenKey = 'plms_access_token' // Token的键
const UserKey = 'plms_user_id'

export function getToken () {
  return sessionStorage.getItem(TokenKey)
}

export function setToken (token) {
  return sessionStorage.setItem(TokenKey, token)
}

export function getUserId (userId) {
  return sessionStorage.setItem(UserKey, userId)
}

export function setUserId (userId) {
  return sessionStorage.setItem(UserKey, userId)
}

export function removeUserId () {
  return sessionStorage.removeItem(UserKey)
}
