import { get, post } from "./http";

// ==================>用户板块
export const getLoginStatus = (params) => post(`/user/login`, params);
