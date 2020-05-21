package cdu.jk.dao;

import org.springframework.stereotype.Repository;
import cdu.jk.entity.Log;
import java.util.List;
/*
　　* @Description:用于记录日志
   * @param null
　　* @return
　　* @throws
　　* @author DXZ1
　　* @date 2020/5/19 14:56
*/
@Repository
public interface LogDao {
    /**
    　　* @Description: 保存日志
       * @param log
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/19 16:55
    */
    int saveLog(Log log);
    /**
    　　* @Description: 查询所有日志
       * @param
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/19 16:55
    */
    List<Log> findAllLog();

    /**
    　　* @Description: 按id删除博客
       * @param ids
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/19 17:12
    */
    int deleteLogs(Integer[] ids);
}
