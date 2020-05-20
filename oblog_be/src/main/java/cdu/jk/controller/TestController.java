package cdu.jk.controller;

import cdu.jk.dao.TestDao;
import cdu.jk.entity.Test;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
*@Description swagger接口测试类
*@Author cdu.bishop.xiao
*@Date 2020/5/18 20:55
*/
@Controller
@Api(description = "Test测试类")
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);
    private TestDao testDao;


    @Autowired
    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }

    /***
    *@Description swagger接口测试方法
    *@Param []
    *@Return java.lang.String
    *@Author cdu.bishop.xiao
    *@Date 2020/5/18 20:56
    *@Modify by xiao 2020/5/18 20:56
    */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "项目部署swagger接口测试方法")
    public String testMethod(@RequestParam(name = "name") String name){

        logger.error("参数进来了：" + name);
        List<Test> result = testDao.selectTest();
        logger.error("查询到数据库 :"+ result);
        Gson gson = new Gson();
        return gson.toJson(result);
    }

}
