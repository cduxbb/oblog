import {
    request
} from './request';
import Qs from 'qs'
// 博客页面所有的请求
// 博客分页查询
export function getAllBlogByPageNum(pageNum) {
    return request({
        url: "/blog/findAllBlog/" + pageNum,
    })
}
// 博客批量删除 blogIds = JSON.stringify({ blogIds: delArr })
export function delMultiplyBlog(delArr) {
    return request({
        url: "/blog/deleteBlogs",
        params: {
            blogIds: delArr
        },
        paramsSerializer: function (params) {
            return Qs.stringify(params, {
                arrayFormat: 'repeat'
            })
        }
    })
}
// 模糊查询
export function findBlogByTitle(title) {
    return request({
        url: "/blog/findBlogByTitle/" + title,
    })
}
// 写博客
export function writeBolg(form) {
    return request({
        url: "blog/insertBlog",
        method: 'POST',
        data: form
    })
}


// 添加博文