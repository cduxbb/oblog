package cdu.jk.utils;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/***
*@Description  自定义访问对象工具类
*@Author cdu.bishop.xiao
*@Date 2020/5/19 18:26
*/
@Service
public class CusAccessObjectUtil {

    /***
    *@Description 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能
     * 用户使用了代理软件方式避免真实IP地址,取X-Forwarded-For中第一个非unknown的有效IP字符串
    *@Param [request] http请求
    *@Return java.lang.String 客户端ip地址
    *@Author cdu.bishop.xiao
    *@Date 2020/5/19 18:27
    *@Modify by xiao 2020/5/19 18:27
    */
    public String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
