package cdu.jk.controller;

import cdu.jk.entity.Blog;
import cdu.jk.service.IBolgService;
import cdu.jk.utils.UserUtil;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

/**
 * @author DXZ1
 * @Title:
 * @Package
 * @Description: 博客controller
 * @date 2020/5/2011:37
 */
@Controller
@RequestMapping("/blog")
@Api(description = "博客相关操作接口Controller")
public class BlogController {
    @Autowired
    private IBolgService blogService;
    private Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private UserUtil userUtil;

    /**
    　　* @Description: 分页查询
       * @param pageNum 页数
    　　* @return json数据
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/20 15:00
    */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "分页查询博客")
    public String findAllBlog(Integer pageNum){
        if(pageNum!=null){
            logger.error("[ 查询所有博客方法 ] --- 参数 >>>> pageNum: "+pageNum);
            List<Blog> allBlog = blogService.findAllBlog(pageNum,10);
            if(allBlog!=null){
                Gson gson = new Gson();
                return gson.toJson(allBlog);
            }else {
                return "404";
            }
        }else {
            return "406";
        }

    }

    /**
    　　* @Description: 插入博客
       * @param blog 用于封装 博主id、标题、内容、标签
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/20 15:11
    */
    @RequestMapping(value = "/insertBlog",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "写博客")
    public String insertBlog(@RequestBody Blog blog){
        if(blog!= null){

            //获取系统时间作为博客创建时间
            String systemDate = userUtil.getSystemDate();
            blog.setCreateTime(systemDate);

            logger.error("[ 写博客方法 ] --- 参数 >>>> blog: "+blog);

            int result = blogService.insertBlog(blog);
            if(result!=0){
                return "200";
            }else{
                return "404";
            }
        }else {
            return "406";
        }
    }

    /**
    　　* @Description: 修改博客
       * @param blog 封装修改后的博客
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/20 15:48
    */
    @RequestMapping(value = "/updateBlog",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改博客")
    public String updateBlog(@RequestBody Blog blog){
        if(blog!= null){
            //获取系统时间作为博客修改时间
            String systemDate = userUtil.getSystemDate();
            blog.setModifyTime(systemDate);
            logger.error("[ 修改博客方法 ] --- 参数 >>>> blog: "+blog);

            int result = blogService.updateBlog(blog);
            if(result!=0){
                return "200";
            }else{
                return "404";
            }
        }else {
            return "406";
        }

    }

    /**
    　　* @Description: 按照博客id查看某一博客内容
       * @param blogId  博客Id
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/20 16:10
    */
    @RequestMapping(value = "/findContent",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "按博客id查看博客")
    public String findBlogContentById(Integer blogId){
        if(blogId != null){
            logger.error("[ 查看博客内容方法 ] --- 参数 >>>> blogId: "+blogId);
            Blog blogCs = blogService.findBlogContent(blogId);
            if(blogCs != null){
                Gson gson = new Gson();
                return gson.toJson(blogCs);
            }else {
                return "404";
            }
        }else {
            return "406";
        }
    }

    /**
    　　* @Description: 批量删除博客
       * @param blogIds 批量删除的博客id
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/20 17:00
    */
    @RequestMapping(value = "/deleteBlogs",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "批量删除博客")
    public String deleteBlogs(Integer[] blogIds){
        if(blogIds !=null && blogIds.length!=0){
            logger.error("[ 删除博客内容方法 ] --- 参数 >>>> blogIds: "+blogIds);
            int result = blogService.deleteBlogs(blogIds);
            if(result !=0){
                return "200";
            }else {
                return "404";
            }
        }else {
            return "406";
        }
    }

}
