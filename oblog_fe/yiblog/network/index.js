import {
  request
} from './request';
// 博客页面所有的请求
// 博客分页查询
export function getAllBlogByPageNum(pageNum) {
  return request({
    url: "/blog/findAllBlog/" + pageNum,
  })
}
export function getAllBlogById(id) {
  return request({
    url: "/blog/findContent/" + id,
  })
}
