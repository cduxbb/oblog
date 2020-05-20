package cdu.jk.entity;

import lombok.Data;

import java.io.Serializable;

/***
 *@Description 评论comment实体类，字段名同数据库名一样
 *@Author cdu.bishop.xiao
 *@Date 2020/5/19 11:37
 */
@Data
public class Comment implements Serializable {

    private Integer commentId; // 评论id
    private String criticIp;   // 评论者IP
    private String content;    // 评论内容
    private String criticTime; // 评论时间
    private Integer blogId;    // 博客id
}
