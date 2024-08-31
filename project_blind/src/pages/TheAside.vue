<template>
  <div>
    <div class="sidebar">
      <!-- 侧边栏内容 -->
      <el-menu
        class="sidebar-el-menu"
        :default-active="onRoutes"
        :collapse="collapse"
        background-color="#324157"
        text-color="#ffffff"
        active-text-color="#20a0ff"
        unique-opened
        router
      >
        <!-- 侧边栏菜单项 -->
        <template v-for="item in filteredItems">
          <el-menu-item :index="item.index" :key="item.index">
            <i :class="item.icon"></i>
            <span slot="title">{{ item.title }}</span>
          </el-menu-item>
        </template>
      </el-menu>
    </div>
    
    <!-- 内容容器 -->
    <div class="content-container">
      <!-- 这里放置内容 -->
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import bus from '../assets/js/bus'

export default {
  mounted() {
    const role = JSON.parse(localStorage.getItem('role'))
    console.log(role);
  },
  data () {
    return {
      collapse: false,
      role: JSON.parse(localStorage.getItem("role")),
      items: [
        {
          icon: 'el-icon-document',
          index: 'user',
          title: '用户管理'
        },
      ]
    }
  },
  computed: {
    onRoutes () {
      return this.$route.path.replace('/', '')
    },
    // 根据用户角色过滤菜单项
    filteredItems() {
      if (this.role && this.role > 1) {
        // 如果用户角色大于 1，则显示所有菜单项
        return this.items;
      } else {
        // 否则，过滤掉需要更高权限的菜单项
        return this.items.filter(item => item.index !== 'admin' && item.index !== 'songList' && item.index !== 'user');
      }
    }
  },
  created () {
    // 使用事件总线折叠侧边栏
    bus.$on('collapse', msg => {
      this.collapse = msg
    })
  }
}
</script>

<style lang="less" scoped>
.sidebar {
  display: block;
  position: absolute;
  background-color: #334256;
  left: 0;
  top: 70px;
  bottom: 0;
  overflow-y: scroll;
}
.sidebar::-webkit-scrollbar {
  width: 0;
}
.sidebar-el-menu:not(.el-menu--collapse) {
  width: 150px;
}
.content-container {
  position: absolute;
  left: 150px; /* 调整这里的值，以匹配侧边栏的宽度 */
  top: 70px;
  right: 0;
  bottom: 0;
  overflow-y: auto;
  padding: 20px; /* 可以根据需要调整内容容器的内边距 */
}
</style>