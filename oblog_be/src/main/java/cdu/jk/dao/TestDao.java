package cdu.jk.dao;

import cdu.jk.entity.Test;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
*@Description 测试方法Dao
*@Author cdu.bishop.xiao
*@Date 2020/5/19 11:53
*/
@Repository
public interface TestDao {

    //查找所有用户
    @Select("select * from oblog_db_test")
    List<Test> selectTest();

}
