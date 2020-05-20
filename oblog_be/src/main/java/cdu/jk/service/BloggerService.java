package cdu.jk.service;

import cdu.jk.entity.Blogger;

/***
*@Description 博主相关业务接口
*@Author cdu.bishop.xiao
*@Date 2020/5/19 12:00
*/
public interface BloggerService {

    // 博主登录
    boolean bloggerLogin(String userName, String password);
    //查询博主个人信息
    Blogger selectBloggerByUserName(String userName);
    //更新博主个人信息
    Integer updateBlogger(Blogger blogger);

}
