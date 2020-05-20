package cdu.jk.service;


import cdu.jk.entity.Log;

import java.util.List;


public interface ILogService {

    int saveLog(Log log);

    List<Log> findAllLog();

    int deleteLog(Integer id);
}
