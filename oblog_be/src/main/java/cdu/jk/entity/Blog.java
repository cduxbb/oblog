package cdu.jk.entity;

import lombok.Data;

import java.io.Serializable;

/***
*@Description 博客blog实体类，字段名同数据库名一样
*@Author cdu.bishop.xiao
*@Date 2020/5/19 11:37
*/
@Data
public class Blog implements Serializable {

    private Integer blogId;     // 博客id
    private String title;       // 博客标题
    private String content;     // 博客内容
    private String createTime;  // 博客创建时间
    private String modifyTime;  // 博客修改时间
    private Integer commentNum; // 评论数
    private Integer bloggerId;  // 博主id
    private String blogType;    // 博客类别、标签
}
