package cdu.jk.service;

import cdu.jk.entity.Comment;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/***
*@Description 评论相关业务接口
*@Author cdu.bishop.xiao
*@Date 2020/5/19 17:42
*/
public interface CommentService {

    // 查看评论
    List<Comment> viewComment(Integer blogId);
    // 写评论
    Integer writeComment(Integer blogId, String content, HttpServletRequest request);
    //写评论成功更新博客表评论条数字段+1
    Integer addCommentNum(Integer commentNum);
    // 删除、批量删除评论
    Integer deleteCommentByCommentId(Integer[] commentIdArray);
}
