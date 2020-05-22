package cdu.jk.service;

import cdu.jk.entity.Blog;

import java.util.List;

/**
 * @author DXZ1
 * @Title:
 * @Package
 * @Description: 博客业务层操作
 * @date 2020/5/2011:34
 */
public interface IBolgService {

    List<Blog> findAllBlog(Integer pageNum,Integer PageSize);

    int insertBlog(Blog blog);

    int updateBlog(Blog blog);

    Blog findBlogContent(Integer id);

    int deleteBlogs(Integer[] blogIds);

    List<Blog> findBlogByTitle(String title);
}
