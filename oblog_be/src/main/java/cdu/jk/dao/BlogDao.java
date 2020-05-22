package cdu.jk.dao;

import cdu.jk.entity.Blog;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author DXZ1
 * @Title:
 * @Package
 * @Description: 用于博客操作
 * @date 2020/5/2011:33
 */
@Repository
public interface BlogDao {

    /**
    　　* @Description: 查询所有,用于分页查询
       * @param
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/20 11:44
    */
    List<Blog> findAllBlog();

    /**
    　　* @Description: 用于插入博客
       * @param blog 封装前台blog数据
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/20 15:38
    */
    int insertBlog(Blog blog);

    /**
    　　* @Description: 修改博客
       * @param blog
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/20 16:05
    */
    int updateBlog(Blog blog);

    /**
    　　* @Description: 查询博客内容
       * @param id 博客id
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/20 16:27
    */
    Blog findBlogContent(Integer id);

    /**
    　　* @Description: 批量删除博客
       * @param blogIds
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/20 17:35
    */
    int deleteBlogs(Integer[] blogIds);

    /**
    　　* @Description: 模糊查询
       * @param title 参数
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/22 9:49
    */
    List<Blog> findBlogByTitle(String title);

}
