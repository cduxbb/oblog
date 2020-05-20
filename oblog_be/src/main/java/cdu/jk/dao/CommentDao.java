package cdu.jk.dao;

import cdu.jk.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/***
*@Description 评论相关dao层
*@Author cdu.bishop.xiao
*@Date 2020/5/19 17:48
*/
@Repository
public interface CommentDao {

    // 查看评论
    @Select("select * from oblog_db_comment where blogId = #{blogId}")
    List<Comment> viewComment(@Param("blogId") Integer blogId);
    // 写评论
    @Insert("insert into oblog_db_comment(criticIp,content,criticTime,blogId) values" +
            "(#{comment.criticIp},#{comment.content},#{comment.criticTime},#{comment.blogId})")
    Integer writeComment(@Param("comment") Comment comment);
    //写评论成功更新博客表评论条数字段+1
    @Update("update oblog_db_blog set commentNum=commentNum+1 where blogId = #{blogId}")
    Integer addCommentNum(@Param("blogId") Integer blogId);
    // 删除、批量删除评论
    Integer deleteCommentByCommentId(Integer[] commentIdArray);
    //删除、批量删除评论成功更新博客表评论条数字段减去对应条数
    @Update("update oblog_db_blog set commentNum = commentNum-#{count} where blogId = #{blogId}")
    Integer reduceCommentNum(@Param("blogId") Integer blogId,@Param("count") Integer count);

}
