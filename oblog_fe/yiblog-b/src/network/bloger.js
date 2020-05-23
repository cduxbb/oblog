import {
  request
} from './request';
// 博客页面所有的请求
// 博客分页查询
export function login(userName, password) {
  return request({
    url: "blogger/login/in",
    method: 'post',
    params: {
      userName,
      password
    }
  })
}
export function addBloger(form) {
  return request({
    url: "blogger/add/blogger",
    params: form
  })
}
export function queryBloger(userName) {
  return request({
    url: "blogger/query/blogger/info",
    method: 'post',
    params: {
      userName
    }
  })
}