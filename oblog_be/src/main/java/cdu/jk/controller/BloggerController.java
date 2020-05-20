package cdu.jk.controller;

import cdu.jk.serviceImpl.BloggerServiceImpl;
import cdu.jk.utils.UserUtil;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/***
*@Description 博主相关接口controller
*@Author cdu.bishop.xiao
*@Date 2020/5/19 15:55
*/
@Controller
@RequestMapping(value = "/blogger")
@Api(description = "博主相关操作接口Controller")
public class BloggerController {

    private BloggerServiceImpl bloggerService;
    private UserUtil userUtil;

    @Autowired
    public void setBloggerService(BloggerServiceImpl bloggerService) {
        this.bloggerService = bloggerService;
    }
    @Autowired
    public void setUserUtil(UserUtil userUtil) {
        this.userUtil = userUtil;
    }

    /***
    *@Description 博主登录请求接口
    *@Param [action, userName, password, response] 记住密码、账号、密码、http响应
    *@Return java.lang.String  返回json数据集
    *@Author cdu.bishop.xiao
    *@Date 2020/5/19 16:44
    *@Modify by xiao 2020/5/19 16:44
    */
    @PostMapping(value = "/login/in")
    @ResponseBody
    @ApiOperation(value = "博主登录")
    public String bloggerLogin(@RequestParam(value = "action",required = false) String action,
                               @RequestParam(value = "userName") String userName,
                               @RequestParam(value = "password") String password){

        List<String> loginResult = new ArrayList<>();
        String ssid = "0";
        if(!"".equals(userName) && !"".equals(password)){ //判断字符串非空
            //调用登录业务
            boolean result = bloggerService.bloggerLogin(userName,password);
            if(result){ //登录成功
                //保存相关cookie信息到本地
                if("remember".equals(action)){
                    //将账号与秘钥使用MD5加密后保存
                    ssid = userUtil.calcMD1(userName);
                }
                loginResult.add(0,"200");
            }else { //登录失败
                loginResult.add(0,"404");
            }
        }else{ //参数为空
            loginResult.add(0,"406");
        }
        loginResult.add(1,userName);
        loginResult.add(2,ssid);
        Gson gson = new Gson();
        return gson.toJson(loginResult);
    }


}
