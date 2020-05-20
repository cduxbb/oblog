package cdu.jk.controller;

import cdu.jk.entity.Comment;
import cdu.jk.serviceImpl.CommentServiceImpl;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/***
*@Description  博客评论相关接口controller
*@Author cdu.bishop.xiao
*@Date 2020/5/19 15:58
*/
@Controller
@RequestMapping(value = "/comment")
@Api(description = "博客评论相关操作接口Controller")
public class CommentController {

    private CommentServiceImpl commentService;

    @Autowired
    public void setCommentService(CommentServiceImpl commentService) {
        this.commentService = commentService;
    }

    /***
    *@Description  查看评论请求接口
    *@Param [blogId] 博客id
    *@Return java.lang.String
    *@Author cdu.bishop.xiao
    *@Date 2020/5/19 17:58
    *@Modify by xiao 2020/5/19 17:58
    */
    @GetMapping(value = "/view/comm")
    @ResponseBody
    @ApiOperation(value = "查看评论")
    public String viewComment(@RequestParam(value = "blogId") Integer blogId){

        if(!"".equals(blogId)){
            List<Comment> viewResult =  commentService.viewComment(blogId);
            if(viewResult != null){ //成功查询
                Gson gson = new Gson();
                return gson.toJson(viewResult);
            }else {
                //参数不对应，业务逻辑失败
                return "404";
            }
        }else { //参数为空
            return "406";
        }
    }

    /***
    *@Description 写评论请求接口
    *@Param [blogId, content]
    *@Return java.lang.String
    *@Author cdu.bishop.xiao
    *@Date 2020/5/19 18:21
    *@Modify by xiao 2020/5/19 18:21
    */
    @GetMapping(value = "/write/comm")
    @ResponseBody
    @ApiOperation(value = "写评论留言")
    public String writeComment(@RequestParam(value = "blogId") Integer blogId,
                               @RequestParam(value = "content") String content,
                               HttpServletRequest request){

        if(!"".equals(blogId) && !"".equals(content)){
            Integer result = commentService.writeComment(blogId,content,request);
            if(result == 1){
                //评论成功博客评论条数+1
                commentService.addCommentNum(blogId);
                return "200";
            }else {
                return "404";
            }
        }else {
            return "406";
        }

    }

}
