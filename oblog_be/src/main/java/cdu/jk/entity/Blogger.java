package cdu.jk.entity;

import lombok.Data;

import java.io.Serializable;

/***
*@Description 博主blogger实体类，字段名同数据库名一样
*@Author cdu.bishop.xiao
*@Date 2020/5/19 11:27
*/
@Data
public class Blogger implements Serializable {

    private Integer id;  //id
    private String userName; //博主用户账号
    private String password; //账号对应密码
    private String nickname; //博主昵称
    private String email;    //博主邮箱
    private String address;  //博主地址
    private String signature;//博主个性签名
}
