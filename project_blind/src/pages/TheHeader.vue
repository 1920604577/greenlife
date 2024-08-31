<template>
  <div class="header">
    <!-- 折叠按钮 -->
    <div class="collapse-btn" @click="collapseChage">
      <i class="el-icon-menu"></i>
    </div>
    <div class="logo">hln - blink</div>
    <div class="header-right">
      <div class="header-user-con">
        <!-- 全屏显示 -->
        <div class="btn-fullscreen" @click="handleFullScreen">
          <el-tooltip effect="dark" :content="fullscreen ? '取消全屏' : '全屏'" placement="bottom">
            <i class="el-icon-rank"></i>
          </el-tooltip>
        </div>
        <!-- 用户头像 -->
        <div class="user-avator">
          <img src="../assets/img/11.jpeg" />
        </div>
        <!-- 用户名下拉菜单 -->
        <el-dropdown class="user-name" trigger="click" @command="handleCommand">
          <span class="el-dropdown-link">
            {{ username }}
            <i class="el-icon-caret-bottom"></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="profiles">个人信息</el-dropdown-item>
            <el-dropdown-item command="notice">消息</el-dropdown-item>
            <el-dropdown-item command="replace">回复</el-dropdown-item>
            <el-dropdown-item command="myBlink">我的约会</el-dropdown-item>
            <el-dropdown-item command="friendReplace">好友申请</el-dropdown-item>
            <el-dropdown-item command="loginout" @click="exit">退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
  </div>
</template>

<script>
import bus from '../assets/js/bus';

export default {
  data() {
    return {
      collapse: true,
      fullscreen: false,
      name: '', // 初始化为空字符串
    };
  },
  computed: {
    username() {
      // 返回当前用户名，如果不存在，则返回默认名称
      return localStorage.getItem('ms_username') || this.name;
    },
  },
  mounted() {
    // 设置默认的用户名
    this.name = '游客';
    // 检查 localStorage 中是否有用户名信息
    const storedName = localStorage.getItem('ms_username');
    console.log(storedName);
    if (storedName) {
      this.name = storedName;
    }
    if (document.body.clientWidth < 1500) {
      this.collapseChage();
    }
  },
  methods: {
    // 用户名下拉菜单选择事件
    handleCommand(command) {
      if(command === 'profiles'){ 
        this.$router.push('/profiles');
      }
      else if(command === 'notice'){ 
        this.$router.push('/notice');
      }
      else if (command === 'replace') { 
        this.$router.push('/replace');
      }
      else if (command === 'myBlink') { 
        this.$router.push('/myBlink');
      }
      else if (command === 'friendReplace') { 
        this.$router.push('/friendReplace');
      }
      else if(command === 'loginout') {
        localStorage.removeItem('ms_username');
        this.$router.push('/');
      }
    },
    //退出登录
    async exit() { 
      const user = JSON.parse(localStorage.getItem('user'));
      localStorage.removeItem('user');
      var object = await synRequestPost("/user/exit?id=" + user.id);
      alert(object.message);
    },
    // 侧边栏折叠
    collapseChage() {
      this.collapse = !this.collapse;
      bus.$emit('collapse', this.collapse);
    },
    // 全屏事件
    handleFullScreen() {
      let element = document.documentElement;
      if (this.fullscreen) {
        if (document.exitFullscreen) {
          document.exitFullscreen();
        } else if (document.webkitCancelFullScreen) {
          document.webkitCancelFullScreen();
        } else if (document.mozCancelFullScreen) {
          document.mozCancelFullScreen();
        } else if (document.msExitFullscreen) {
          document.msExitFullscreen();
        }
      } else {
        if (element.requestFullscreen) {
          element.requestFullscreen();
        } else if (element.webkitRequestFullScreen) {
          element.webkitRequestFullScreen();
        } else if (element.mozRequestFullScreen) {
          element.mozRequestFullScreen();
        } else if (element.msRequestFullscreen) {
          element.msRequestFullscreen();
        }
      }
      this.fullscreen = !this.fullscreen;
    },
  },
};
</script>

<style lang="less" scoped>
.header {
  position: fixed;
  top: 0;
  left: 0;
  background-color: #253041;
  box-sizing: border-box;
  width: 100%;
  height: 70px;
  font-size: 22px;
  color: #fff;
  z-index: 999; /* 确保在其他内容的上层 */
}

.collapse-btn {
  float: left;
  padding: 0 21px;
  cursor: pointer;
  line-height: 70px;
}
.header .logo {
  float: left;
  width: 250px;
  line-height: 70px;
}
.header-right {
  float: right;
  padding-right: 50px;
}
.header-user-con {
  display: flex;
  height: 70px;
  align-items: center;
}
.btn-fullscreen {
  transform: rotate(45deg);
  margin-right: 5px;
  font-size: 24px;
}
.user-name {
  margin-left: 10px;
}
.user-avator {
  margin-left: 20px;
}
.user-avator img {
  display: block;
  width: 40px;
  height: 40px;
  border-radius  : 50%;
}
.el-dropdown-link {
  color: #fff;
  cursor: pointer;
}
.el-dropdown-menu__item {
  text-align: center;
}
</style>
