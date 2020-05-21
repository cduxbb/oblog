package cdu.jk.entity;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/***
*@Description 日志记录log实体类，字段名同数据库名一样
*@Author cdu.bishop.xiao
*@Date 2020/5/19 11:45
*/
@Data
@ToString
public class Log implements Serializable {

    private Integer logId;    //日志id
    private String logTime;   //日志记录时间
    private String ip;        //使用者IP
    private String visitUrl;  //访问路径
    private String visitMethod; //访问方法
}
