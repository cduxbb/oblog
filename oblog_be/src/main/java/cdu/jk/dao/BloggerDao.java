package cdu.jk.dao;

import cdu.jk.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
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

}
