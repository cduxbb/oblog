import {
  request
} from './request';
import Qs from 'qs'
export function getAllLog(pageNum) {
  return request({
    url: "log/findAllLog/" + pageNum,
  })
}

// 博客批量删除 blogIds = JSON.stringify({ blogIds: delArr })
export function delMultiplylog(delArr) {
  return request({
    url: "/blog/deleteLogs",
    params: {
      id: delArr,
    },
    paramsSerializer: function (params) {
      return Qs.stringify(params, {
        arrayFormat: 'repeat'
      })
    }
  })
}