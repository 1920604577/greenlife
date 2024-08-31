<template>
    <div class="login">
      <div class="login-box">
        <div style="flex: 1">
          <el-form :model="user" :rules="rules">
            <div style="font-size: 20px; font-weight: bold; text-align: center; margin-bottom: 18px">欢迎注册hln-后台系统账号</div>
            <el-form-item prop="username">
              <el-input prefix-icon="el-icon-user" size="medium" v-model="user.username" placeholder="请输入账号"></el-input>
            </el-form-item>
            <el-form-item prop="password1">
              <el-input prefix-icon="el-icon-lock" show-password size="medium" v-model="user.password1" placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item prop="password2">
              <el-input prefix-icon="el-icon-lock" show-password size="medium" v-model="user.password2" placeholder="再次输入密码"></el-input>
            </el-form-item>
            <el-form-item label="性别" style="color:#222222;">
                <el-radio-group v-model="user.sex">
                <el-radio :label="0">男</el-radio>
                <el-radio :label="1">女</el-radio>
                </el-radio-group>
            </el-form-item>
            <el-form-item prop="birthData">
                <el-date-picker type="date" placeholder="请选择日期" v-model="user.birthData" style="width: 100%;"></el-date-picker>
            </el-form-item>
            <el-form-item>
              <el-button @click="register" type="success">注册</el-button>
            </el-form-item>
            <div style="display: flex;">
              <div style="flex: 1"><h3>前往<span @click="toLogin" style="color:blue;cursor: pointer">登录</span>页面</h3></div>
            </div>
          </el-form>
        </div>
      </div>
    </div>
  </template>
  
  <script>
import axios from 'axios';
import { synRequestPost } from "../../static/request";

  export default {
    name: 'Login_In',
    data() {
      var validatePass2 = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请再次输入密码'));
        } else if (value !== this.user.password1) {
          callback(new Error('两次输入密码不一致!'));
        } else {
          callback();
        }
      }
      return {
        user: {
          username: '',
          password1: '',
          password2: '',
          sex: '',
          birthData:''
          },
        UserRegBo: {
          username: '',
          password: '',
          sex: '',
          birthData:''
        },
        rules: {
          username: [
            { min: 2, max: 11, message: '长度在 2 到 11 个字符', trigger: 'blur' },
          ],
          password2: [
            { min: 3, max: 11, message: '长度在 3 到 11 个字符', trigger: 'blur' },
            { validator: validatePass2, trigger: 'blur'}
          ],
          password1: [
            { min: 3, max: 11, message: '长度在 3 到 11 个字符', trigger: 'blur' }
          ],
        },
  
      }
    },
    methods: {
      async register() {
        let d = new Date(this.user.birthData)
            let datetime = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate()
            this.UserRegBo.username = this.user.username;
            this.UserRegBo.password = this.user.password1;
            this.UserRegBo.sex = this.user.sex;
            this.UserRegBo.birthData = datetime;
            var object = await synRequestPost("/user/userReg", this.UserRegBo);
            alert(object.message)
      },
      toLogin(){
        this.$router.push('/')
      }
    },
    mounted() {
      // console.log(this.user.username);
  
    }
  }
  </script>
  
  <style>
  html, body {
    height: 100%;
    margin: 0;
    padding: 0;
  }
  
  .login {
    height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    background-image: url('../assets/img/404.jpg');
    background-size: cover;
    background-repeat: no-repeat;
  }
  
  .login-box {
    display: flex;
    width: 100%;
    max-width: 500px;
    border-radius: 5px;
    overflow: hidden;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
  }
  
  .el-form {
    margin: 85px 15px;
  
  }
  
  .s-canvas {
    display: flex;
    justify-content: center;
  }
  .el-button--success {
    color: #FFF;
    background-color: rgba(15, 152, 220) !important;
    border-color: rgba(15, 152, 220) !important;
    cursor: pointer;
    margin-top: 16px;
    width: 100%
  }
  </style>
  