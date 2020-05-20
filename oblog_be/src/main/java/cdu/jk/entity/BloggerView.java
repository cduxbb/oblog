package cdu.jk.entity;

import lombok.Data;

/***
*@Description 编辑博主个人信息实体类
*@Author cdu.bishop.xiao
*@Date 2020/5/20 13:26
*/
@Data
public class BloggerView {

    private String userName; //博主用户账号
    private String nickname; //博主昵称
    private String email;    //博主邮箱
    private String address;  //博主地址
    private String signature;//博主个性签名
}
