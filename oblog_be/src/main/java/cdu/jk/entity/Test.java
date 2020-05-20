package cdu.jk.entity;
import lombok.Data;

import java.io.Serializable;

/***
*@Description 测试数据库实体类
*@Author cdu.bishop.xiao
*@Date 2020/5/19 11:55
*/
@Data
public class Test implements Serializable {

    private Integer id;
    private String name;
}
