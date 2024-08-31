<template>
  <div class="login-wrap">
    <div class="login-container">
      <div class="login-image">
        <img :src="loginImage" alt="Login Image">
      </div>
      <div class="vertical-divider"></div>
      <div class="ms-login">
        <el-form
          :model="ruleForm"
          ref="ruleForm"
          class="demo-ruleForm"
        >
          <h2 class="mt-4">登入您的账户</h2>
          <el-form-item prop="username" style="margin-bottom: 10px;">
            <el-input v-model="userLoginBo.username" placeholder="username"></el-input><br>
          </el-form-item>
          <el-form-item prop="password">
            <el-input
              type="password"
              placeholder="password"
              style="margin-bottom: 10px;"
              v-model="userLoginBo.password"
              @keyup.enter.native="submitForm('ruleForm')"
            ></el-input><br>
          </el-form-item>
          <p style="">Tips : 用户名和密码要和自己设置的一致奥!。</p>
          <div style="font-size:12px;line-height:30px;color:#999;margin-left: 20%;">
            <el-button type="primary" @click="submitForm" @keyup.enter="submitForm">登录</el-button>
            <el-button type="primary" @click="goReg">注册</el-button>
          </div>
        </el-form>
      </div>
    </div>
  </div>
</template>

<script>
import { setToken } from "/static/ZuiBlog/token";
import { setCookie } from "/static/ZuiBlog/ZuiBlog"
import { synRequestPost } from "../../static/request";
import { MessageBox } from 'element-ui';

export default {
  data() {
    return {
      ruleForm: {
        username: '',
        password: ''
      },
      userLoginBo: {
        username: "",
        password: "",
        code: "",
        key: ""
      },
      switchButton: false,
      srcImg: require('@/assets/img/404.jpg'),
      loginImage: require('@/assets/img/404.jpg'), 
    };
  },
  methods: {
    goReg() { 
      this.$router.push("/userReg");
    },
    async submitForm() {
      this.switchButton = true;
      var object = await synRequestPost("/user/login", this.userLoginBo);
      console.log(object);
      if (object.code != "0x200") {
        MessageBox.alert('登录失败', '提示', {
          confirmButtonText: '确定',
          type: 'error'
        });
        alert(object.message);
        this.userLoginBo.username = "";
        this.userLoginBo.password = "";
        this.userLoginBo.key = "";
        this.userLoginBo.code = "";
        this.switchButton = false;
        return;
      }
      setCookie('token', object.data.token);
      console.log(object.data.token);
      localStorage.setItem("user", JSON.stringify(object.data.user));
      localStorage.setItem("role", JSON.stringify(object.data.role));
      localStorage.setItem("ms_username", object.data.user.username);
      alert(object.message);
      this.$router.push("/home");
      MessageBox.alert('登录成功', '提示', {
        confirmButtonText: '确定',
        type: 'success'
      });
      this.switchButton = false;
    }
  }
};
</script>

<style lang="less" scoped>
.login-wrap {
  background: url('~@/assets/img/404搞怪.jpg') no-repeat center center fixed;
  background-size: cover;
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}

.login-container {
  display: flex;
  height: 500px;
  background: rgba(255, 255, 255, 0.8);
  border-radius: 5px;
  overflow: hidden;
  width: 70%;
  max-width: 900px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.login-image {
  width: 40%; /* 调整为白框的40% */
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #f2f2f2;
}

.login-image img {
  max-width: 100%; /* 缩小为白框的80% */
  height: 500px;
}

.vertical-divider {
  width: 1px;
  background-color: #ddd;
}

.ms-login {
  width: 60%; /* 调整为白框的60% */
  padding: 40px;
  display: flex;
  flex-direction: column;
  justify-content: center;
}

.el-form-item {
  max-width: 80%; /* 缩小为白框的80% */
  margin: 0 auto;
}

.ms-title {
  position: absolute;
  top: 50px;
  width: 100%;
  text-align: center;
  font-size: 30px;
  font-weight: 600;
  color: #fff;
}

.login-btn {
  text-align: center;
}

.login-btn button {
  width: 80%; /* 缩小为白框的80% */
  height: 36px;
  margin: 0 auto;
}

.mt-4 {
  text-align: center;
}

.pointer{
  width: 40%;
  height: 50px;
  margin: 0;
  display: inline-block;
  vertical-align: middle;
  margin-left: 10%;
}
</style>
