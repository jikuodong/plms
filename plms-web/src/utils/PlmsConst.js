/* eslint-disable */
export default{
  install (Vue, options) {
    Vue.prototype.getData = function (constName) {
      return eval(constName)
    }
  }
}
// *********************************   定义各常量的值   ****************************** //
//                  初始化方法： 在组件中初始化时，定义变量接受全局VUE                 //
//                  方法中使用： this.别名.getData('常量名')                           //
// *********************************************************************************** //

/* ************************************ 操作的URL地址 start ****************************** */
// 登录URL
const LOGIN_URL = 'login'
// const TEST_URL = 'user/addUserInfo'
const TEST_URL = 'laboratory/addLab'

/* ************************************ 操作的URL地址 end ****************************** */
