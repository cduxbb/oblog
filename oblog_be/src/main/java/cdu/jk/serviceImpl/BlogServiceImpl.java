package cdu.jk.serviceImpl;

import cdu.jk.dao.BlogDao;
import cdu.jk.entity.Blog;
import cdu.jk.service.IBolgService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DXZ1
 * @Title:
 * @Package
 * @Description: 博客业务层操作
 * @date 2020/5/2011:35
 */
@Service
public class BlogServiceImpl implements IBolgService {
    @Autowired
    private BlogDao blogDao;


    /**
    　　* @Description: 查询所有,用于分页查询
       * @param pageNum
     * @param PageSize  默认10条
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/20 14:59
    */
    @Override
    public List<Blog> findAllBlog(Integer pageNum,Integer PageSize) {

        //分页查询
        PageHelper.startPage(pageNum,PageSize);
        return blogDao.findAllBlog();
    }

    /**
    　　* @Description: 插入博客
       * @param blog  封装前台blog数据
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/20 15:40
    */
    @Override
    public int insertBlog(Blog blog) {
        return blogDao.insertBlog(blog);
    }

    /**
    　　* @Description: 修改博客
       * @param blog
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/20 16:05
    */
    @Override
    public int updateBlog(Blog blog) {
        return blogDao.updateBlog(blog);
    }

    /**
    　　* @Description: 查询博客内容
       * @param id 博客id
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/20 16:28
    */
    @Override
    public Blog findBlogContent(Integer id) {
        return blogDao.findBlogContent(id);
    }

    /**
    　　* @Description: 批量删除博客
       * @param blogIds
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/20 17:35
    */
    @Override
    public int deleteBlogs(Integer[] blogIds) {
        return blogDao.deleteBlogs(blogIds);
    }

    /**
    　　* @Description: 模糊查询博客
       * @param title
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/22 9:50
    */
    @Override
    public List<Blog> findBlogByTitle(String title) {
        return blogDao.findBlogByTitle(title);
    }


}
