package cdu.jk.controller;

import cdu.jk.entity.Blogger;
import cdu.jk.entity.BloggerView;
import cdu.jk.serviceImpl.BloggerServiceImpl;
import cdu.jk.utils.UserUtil;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(BloggerController.class);
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

        logger.error("action: "+ action + " userName: "+ userName + " password: "+ password);
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
    /***
    *@Description 查询博主个人信息请求接口
    *@Param [userName] 博主账号
    *@Return java.lang.String 博主个人信息表
    *@Author cdu.bishop.xiao
    *@Date 2020/5/20 13:33
    *@Modify by xiao 2020/5/20 13:33
    */
    @PostMapping(value = "/query/blogger/info")
    @ResponseBody
    @ApiOperation(value = "查询博主个人信息")
    public String selectBloggerByUserName(@RequestParam(value = "userName") String userName){

        logger.error("userName: " + userName);
        if(!"".equals(userName)){
            Blogger isBlogger = bloggerService.selectBloggerByUserName(userName);
            if(isBlogger != null){//查到个人信息，设置密码为*
                isBlogger.setPassword("*");
                Gson gson = new Gson();
                return gson.toJson(isBlogger);
            }else{
                return "404";
            }
        }else{
            return "406";
        }
    }
    /***
    *@Description 更新博主个人信息
    *@Param [blogger] 博主视图信息
    *@Return java.lang.String 前后端约定状态码
    *@Author cdu.bishop.xiao
    *@Date 2020/5/20 13:39
    *@Modify by xiao 2020/5/20 13:39
    */
    @GetMapping(value = "/update/blogger/info")
    @ResponseBody
    @ApiOperation(value = "更新博主个人信息")
    public String updateBlogger(@RequestBody BloggerView blogger){

        logger.error("blogger " + blogger.toString());
        if(!"".equals(blogger.getUserName())){
            Integer updateResult = bloggerService.updateBlogger(blogger);
            if(updateResult == 1){
                return "200";
            }else {
                return "404";
            }
        }else {
            return "406";
        }
    }
    /***
    *@Description 添加博主
    *@Param [userName, password, email, nickname, addres] 参数
    *@Return java.lang.String 前后端约定状态码
    *@Author cdu.bishop.xiao
    *@Date 2020/5/20 14:27
    *@Modify by xiao 2020/5/20 14:27
    */
    @GetMapping(value = "/add/blogger")
    @ResponseBody
    @ApiOperation(value = "添加博主")
    public String addBlogger(@RequestParam(value = "userName") String userName,
                             @RequestParam(value = "password") String password,
                             @RequestParam(value = "email") String email,
                             @RequestParam(value = "nickname",required = false) String nickname,
                             @RequestParam(value = "address",required = false) String addres){

        Blogger blogger = new Blogger();
        blogger.setUserName(userName);
        blogger.setPassword(password);
        blogger.setEmail(email);
        blogger.setNickname(nickname);
        blogger.setAddress(addres);
        logger.error("参数："+ blogger.toString());
        if(!"".equals(userName) && !"".equals(password) && !"".equals(email)){
            Integer addResult = bloggerService.addBlogger(blogger);
            if(addResult == 1){
                return "200";
            }else {
                return "404";
            }
        }else {
            return "406";
        }
    }

}
