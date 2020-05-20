package cdu.jk.controller;

import cdu.jk.entity.Log;

import cdu.jk.serviceImpl.LogServiceImpl;
import com.google.gson.Gson;
import io.swagger.annotations.ApiOperation;

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
public class LogController {

    @Autowired
    private LogServiceImpl logService;
    @RequestMapping(value = "/findAllLog",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询所有日志")
    public String findUserLog(){
        //进行查询
        List<Log> allLog = logService.findAllLog();
        Gson gson = new Gson();
        return gson.toJson(allLog);
    }

    @RequestMapping(value = "/deleteLog",method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "按id删除日志")
    public String deletelogById(Integer id){

        if(id !=null){//参数不为空
            int result = logService.deleteLog(id);
            if(result==1){//删除成功
                return "200";
            }else {
                return "500";
            }
        }else {
            return "406";
        }
    }


}
