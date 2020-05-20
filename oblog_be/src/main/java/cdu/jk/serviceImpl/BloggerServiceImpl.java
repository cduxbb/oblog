package cdu.jk.serviceImpl;

import cdu.jk.dao.BloggerDao;
import cdu.jk.entity.Blogger;
import cdu.jk.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public Blogger selectBloggerByUserName(String userName) {
        return null;
    }

    @Override
    public Integer updateBlogger(Blogger blogger) {
        return null;
    }
}
