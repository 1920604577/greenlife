//保存token到本地
export const setToken = (token)=>{
    localStorage.setItem("TOKEN",token);
};
//获取token
export const getToken = ()=>{
  return  localStorage.getItem("TOKEN");
};
//消除token
export const removeToken=()=>{
    localStorage.removeItem("TOKEN")
}
// const TOKENKEY = 'token_key'

// function setToken(token) {
//     return localStorage.setItem(TOKENKEY, token)
// }

// function getToken() {
//     return localStorage.getItem(TOKENKEY)
// }

// function clearToken() {
//     return localStorage.removeItem(TOKENKEY)
// }

// export {
//     setToken,
//     getToken,
//     clearToken
// }
