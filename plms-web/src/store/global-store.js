import Vue from 'vue'
import Vuex from 'vuex'
import states from './modules/states'
import mutations from './modules/mutations'
import actions from './modules/actions'
import getters from './modules/getters'

Vue.use(Vuex)

export default new Vuex.Store({
  states,
  mutations,
  actions,
  getters
})
