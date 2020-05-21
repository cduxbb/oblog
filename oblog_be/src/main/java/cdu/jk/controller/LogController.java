package cdu.jk.controller;

import cdu.jk.entity.Log;

import cdu.jk.serviceImpl.LogServiceImpl;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

/**
 * @author DXZ1
 * @Title:
 * @Package
 * @Description: 用于日志的controller
 * @date 2020/5/1916:18
 */
@RequestMapping("/log")
@Controller
@Api(description = "日志相关操作接口Controller")
public class LogController {

    @Autowired
    private LogServiceImpl logService;
    private Logger logger = LoggerFactory.getLogger(TestController.class);



    @RequestMapping(value = "/findAllLog",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询所有日志")
    public String findUserLog(Integer pageNum){
        if(pageNum!=null){
            logger.error("[ 查询所有日志方法 ] --- 参数 >>>>");
            //进行查询
            List<Log> allLog = logService.findAllLog(pageNum);
            if(allLog!=null){
                Gson gson = new Gson();
                return gson.toJson(allLog);
            }else {
                return "404";
            }

        }else {
            return "406";
        }

    }

    @RequestMapping(value = "/deleteLogs",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "按id批量删除日志")
    public String deletelogsById(Integer[] id){

        logger.error("[ 删除日志方法 ] --- 参数 >>>> Id：" +id );
        if(id !=null){//参数不为空
            int result = logService.deleteLogs(id);
            if(result==0){//删除不成功
                return "404";
            }else {
                return "200";
            }
        }else {
            return "406";
        }
    }


}
