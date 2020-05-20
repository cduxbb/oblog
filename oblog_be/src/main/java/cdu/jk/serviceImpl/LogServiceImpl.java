package cdu.jk.serviceImpl;

import cdu.jk.dao.LogDao;
import cdu.jk.entity.Log;
import cdu.jk.service.ILogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @author DXZ1
 * @Title:
 * @Package
 * @Description: 记录日志服务
 * @date 2020/5/1914:58
 */
@Service
public class LogServiceImpl  implements ILogService {


    @Autowired
    private LogDao logDao;

    /**
    　　* @Description: 保存日志
       * @param log
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/19 16:57
    */
    @Override
    public int saveLog(Log log) {
        return logDao.saveLog(log);
    }

    /**
    　　* @Description: 查询所有日志
       * @param
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/19 16:57
    */
    @Override
    public List<Log> findAllLog() {
        return logDao.findAllLog();
    }

    /**
    　　* @Description: 删除日志
       * @param id
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/19 17:13
    */
    @Override
    public int deleteLogs(Integer[] id) {
        return logDao.deleteLogs(id);
    }


}
