package cdu.jk.serviceImpl;

import cdu.jk.dao.CommentDao;
import cdu.jk.entity.Comment;
import cdu.jk.service.CommentService;
import cdu.jk.utils.CusAccessObjectUtil;
import cdu.jk.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/***
*@Description 评论相关接口实现类
*@Author cdu.bishop.xiao
*@Date 2020/5/19 17:45
*/
@Service
public class CommentServiceImpl implements CommentService {

    private CommentDao commentDao;
    private UserUtil userUtil;
    private CusAccessObjectUtil cusAccessObjectUtil;

    @Autowired
    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }
    @Autowired
    public void setUserUtil(UserUtil userUtil) {
        this.userUtil = userUtil;
    }
    @Autowired
    public void setCusAccessObjectUtil(CusAccessObjectUtil cusAccessObjectUtil) {
        this.cusAccessObjectUtil = cusAccessObjectUtil;
    }

    /***
    *@Description 查看评论业务逻辑
    *@Param [blogId] 博客id
    *@Return java.util.List<cdu.jk.entity.Comment> 评论实体集合
    *@Author cdu.bishop.xiao
    *@Date 2020/5/19 17:51
    *@Modify by xiao 2020/5/19 17:51
    */
    @Override
    public List<Comment> viewComment(Integer blogId) {

        return commentDao.viewComment(blogId);
    }
    /***
    *@Description 写评论业务逻辑
    *@Param [blogId, content, request] 博客id、评论内容、http请求
    *@Return java.lang.Integer 数据库执行条数
    *@Author cdu.bishop.xiao
    *@Date 2020/5/19 18:33
    *@Modify by xiao 2020/5/19 18:33
    */
    @Override
    public Integer writeComment(Integer blogId, String content, HttpServletRequest request) {

        Comment comment = new Comment();
        String criticTime = userUtil.getSystemDate(); //获取系统时间
        String criticIp = cusAccessObjectUtil.getIpAddress(request); //获取客户端IP地址
        comment.setBlogId(blogId);
        comment.setContent(content);
        comment.setCriticIp(criticIp);
        comment.setCriticTime(criticTime);
        //写入评论到数据库
        return commentDao.writeComment(comment);
    }
    /***
    *@Description 写评论成功更新博客表评论条数字段+1
    *@Param [commentNum] 评论条数
    *@Return java.lang.Integer
    *@Author cdu.bishop.xiao
    *@Date 2020/5/19 18:53
    *@Modify by xiao 2020/5/19 18:53
    */
    @Override
    public Integer addCommentNum(Integer blogId) {

        return commentDao.addCommentNum(blogId);
    }

    /***
    *@Description 删除、批量删除评论业务逻辑
    *@Param [commentIdArray]
    *@Return java.lang.Integer
    *@Author cdu.bishop.xiao
    *@Date 2020/5/20 11:02
    *@Modify by xiao 2020/5/20 11:02
    */
    @Override
    public Integer deleteCommentByCommentId(Integer[] commentIdArray) {

        return commentDao.deleteCommentByCommentId(commentIdArray);
    }
    /***
    *@Description 删除、批量删除评论成功更新博客表评论条数字段减去对应条数
    *@Param [blogId, count]
    *@Return java.lang.Integer
    *@Author cdu.bishop.xiao
    *@Date 2020/5/20 11:56
    *@Modify by xiao 2020/5/20 11:56
    */
    @Override
    public Integer reduceCommentNum(Integer blogId, Integer count) {

        return commentDao.reduceCommentNum(blogId,count);
    }
}
