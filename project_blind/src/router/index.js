// src/router/index.js
import Vue from "vue";
import VueRouter from "vue-router";
import { getCookie } from "/static/ZuiBlog/ZuiBlog";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    // meta: { name: "登录界面", requiresAuth: true },
    component: (resolve) => require(["../pages/Login.vue"], resolve),
  },
  {
    path: "*",
    name: "404",
    component: (resolve) => require(["../components/Error.vue"], resolve),
    meta: { requiresAuth: true },
  },
  //如果有需要就参考此处
  // {
  //   path: "/home",
  //   name: "Home",
  //   component: (resolve) => require(["../components/Home.vue"], resolve),
  //   meta: { requiresAuth: true },
  //   children: [],
  // },
  {
    path: "/userReg",
    name: "UserReg",
    // meta: { name: "用户注册" },
    component: (resolve) => require(["../pages/UserRegPage.vue"], resolve),
  },
];

const router = new VueRouter({
  routes,
});

// router.beforeEach((to, from, next) => {
//   // to:可以获得你想要跳转到那个路由的信息
//   //from: 可以获取到你从那个路由来的
//   // next :  放行函数 next() 放行 next(path) 放行到那个指定路由
//   let token = getCookie("token");
//   if (to.matched.some((record) => record.meta.requiresAuth)) {
//     // 需要身份验证的路由
//     if (token) {
//       next(); // 用户已登录，继续导航
//     } else {
//       next("/"); // 用户未登录，重定向到登录页
//     }
//   } else {
//     next(); // 不需要身份验证的路由，直接继续导航
//   }
// });

export default router;
