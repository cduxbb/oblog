package cdu.jk.dao;

import cdu.jk.entity.Blogger;
import cdu.jk.entity.BloggerView;
import cdu.jk.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
*@Description 博主相关dao层
*@Author cdu.bishop.xiao
*@Date 2020/5/19 16:07
*/
@Repository
public interface BloggerDao {

    // 博主登录
    @Select("select password from oblog_db_blogger where userName = #{userName}")
    String bloggerLogin(@Param("userName") String userName);
    //查询博主个人信息
    @Select("select * from oblog_db_blogger where userName = #{userName}")
    Blogger selectBloggerByUserName(@Param("userName") String userName);
    //更新博主个人信息
    @Update("update oblog_db_blogger set nickname = #{blogger.nickname},email = " +
            "#{blogger.email},address = #{blogger.address},signature = #{blogger.signature}" +
            " where userName = #{blogger.userName}")
    Integer updateBlogger(@Param("blogger") BloggerView blogger);
    //添加用户
    @Insert("insert into oblog_db_blogger(userName,password,nickname,email,address) values" +
            "(#{blogger.userName},#{blogger.password},#{blogger.nickname},#{blogger.email},#{blogger.address})")
    Integer addBlogger(@Param("blogger") Blogger blogger);

}
