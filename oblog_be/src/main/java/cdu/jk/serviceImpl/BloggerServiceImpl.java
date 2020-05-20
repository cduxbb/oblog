package cdu.jk.serviceImpl;

import cdu.jk.dao.BloggerDao;
import cdu.jk.entity.Blogger;
import cdu.jk.entity.BloggerView;
import cdu.jk.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
*@Description 博主相关接口实现类
*@Author cdu.bishop.xiao
*@Date 2020/5/19 12:00
*/
@Service
public class BloggerServiceImpl implements BloggerService {

    private BloggerDao bloggerDao;

    @Autowired
    public void setBloggerDao(BloggerDao bloggerDao) {
        this.bloggerDao = bloggerDao;
    }

    /***
    *@Description 博主登录业务逻辑
    *@Param [userName, password] 博主账号  ，博主密码
    *@Return boolean 密码校验状态
    *@Author cdu.bishop.xiao
    *@Date 2020/5/19 16:22
    *@Modify by xiao 2020/5/19 16:22
    */
    @Override
    public boolean bloggerLogin(String userName, String password) {

        String isPassword = bloggerDao.bloggerLogin(userName);
        if(password.equals(isPassword)){ //密码匹配
            return true;
        }else{ //密码不匹配
            return false;
        }
    }
    /***
    *@Description 查询博主个人信息
    *@Param [userName] 博主账号
    *@Return cdu.jk.entity.Blogger 博主信息表
    *@Author cdu.bishop.xiao
    *@Date 2020/5/20 13:17
    *@Modify by xiao 2020/5/20 13:17
    */
    @Override
    public Blogger selectBloggerByUserName(String userName) {

        return bloggerDao.selectBloggerByUserName(userName);
    }
    /***
    *@Description 更新博主个人信息
    *@Param [blogger] 博主个人信息表
    *@Return java.lang.Integer 数据库执行返回值
    *@Author cdu.bishop.xiao
    *@Date 2020/5/20 13:20
    *@Modify by xiao 2020/5/20 13:20
    */
    @Override
    public Integer updateBlogger(BloggerView blogger) {

        return bloggerDao.updateBlogger(blogger);
    }
    /***
    *@Description 添加用户
    *@Param [blogger] 博主表
    *@Return java.lang.Integer 数据库执行返回值
    *@Author cdu.bishop.xiao
    *@Date 2020/5/20 14:04
    *@Modify by xiao 2020/5/20 14:04
    */
    @Override
    public Integer addBlogger(Blogger blogger) {

        return bloggerDao.addBlogger(blogger);
    }
}
