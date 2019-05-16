<template>
  <div class="layout">
    <Layout>
      <Sider  ref="side1" collapsible hide-trigger :width="175" :collapsed-width="64" :style="{background: '#293038'}" v-model="isCollapsed">
        <Menu @on-select="handleSelect" :active-name="activeMenuName" theme="dark" width="auto">
          <Submenu  v-for="(menu, index) in asyncRouters" :key="index" :name="menu.name">
            <template slot="title">
              <Icon size="34px" :type="menu.meta.icon"></Icon>
              <span>{{menu.meta.title}}</span>
            </template>
            <MenuItem v-for="(menu2, index) in menu.children" :key="index" :name="menu2.name">
              <span>{{menu2.meta.title}}</span>
            </MenuItem>
          </Submenu>
        </Menu>
      </Sider>
      <Layout>
        <Header :style="{padding: 0}" class="layout-header-bar">
          <Icon @click.native="collapsedSider" :class="rotateIcon" :style="{margin: '0 20px'}" type="md-menu" size="24"></Icon>
        </Header>
        <Content :style="{minHeight: '280px', background: '#fff', height: '100%'}">
          <router-view/>
        </Content>
      </Layout>
    </Layout>
  </div>
</template>

<script>
import {mapGetters} from 'vuex'
export default {
  name: 'Layouts',
  data () {
    return {
      activeMenuName: '',
      isCollapsed: false
    }
  },
  methods: {
    handleSelect (name) {
      this.$router.push({name: name})
    },
    collapsedSider () {
      this.$refs.side1.toggleCollapse()
    }
  },
  computed: {
    ...mapGetters([
      'asyncRouters'
    ]),
    rotateIcon () {
      return [
        'menu-icon',
        this.isCollapsed ? 'rotate-icon' : ''
      ]
    },
    menuitemClasses () {
      return [
        'menu-item',
        this.isCollapsed ? 'collapsed-menu' : ''
      ]
    }
  },
  mounted () {
    this.activeMenuName = this.asyncRouters[0].children[0].name
  },
  watch: {
    activeMenuName (name) {
      this.$router.push({name: name})
    }
  }
}
</script>

<style scoped>
  .layout{
    border: 1px solid #d7dde4;
    background: #f5f7f9;
    position: relative;
    border-radius: 4px;
    overflow: hidden;
  }
  .layout-header-bar{
    background: #fff;
    box-shadow: 0 1px 1px rgba(0,0,0,.1);
  }
  .layout-logo-left{
    width: 90%;
    height: 30px;
    background: #5b6270;
    border-radius: 3px;
    margin: 15px auto;
  }
  .menu-icon{
    transition: all .3s;
  }
  .rotate-icon{
    transform: rotate(-90deg);
  }
  .menu-item span{
    display: inline-block;
    overflow: hidden;
    width: 69px;
    text-overflow: ellipsis;
    white-space: nowrap;
    vertical-align: bottom;
    transition: width .2s ease .2s;
  }
  .menu-item i{
    transform: translateX(0px);
    transition: font-size .2s ease, transform .2s ease;
    vertical-align: middle;
    font-size: 16px;
  }
  .collapsed-menu span{
    width: 0px;
    transition: width .2s ease;
  }
  .collapsed-menu i{
    transform: translateX(5px);
    transition: font-size .2s ease .2s, transform .2s ease .2s;
    vertical-align: middle;
    font-size: 22px;
  }
</style>
