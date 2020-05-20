package cdu.jk.utils;

import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

/***
 *@Description 用户信息等相关操作的工具类
 *@Author cdu.xbb.xiao
 *@Date 2020/4/23 11:39
 */

@Service
public class UserUtil {

    private static final String KEY = ":cookie@cdu.oblog.com"; // 密钥
    private UserUtil userUtil;

    public void setUserInfoUtil(UserUtil userUtil) {
        this.userUtil = userUtil;
    }

    /***
     *@Description 获取当前系统时间
     *@Param []
     *@Return java.lang.String 返回当前系统时间
     *@Author cdu.xbb.xiao
     *@Date 2020/4/28 13:34
     */
    public String getSystemDate() {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(new Date());
        return date;
    }

    /**
     * @Auther cdu 肖彬斌
     * @Description: MD5加密算法，验证cookie等账号信息
     * @params: [ss] 账号信息
     * @return: java.lang.String
     * @Date: 2019/8/27 14:16
     * @Modified By: name
     */
    public String calcMD1(String ss) {
        ss = ss + KEY;
        String s = ss == null ? "" : ss; // 若为null返回空
        char hexDigits[] = {'0', '1', '2', '3', '4', '1', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'}; // 字典
        try {
            byte[] strTemp = s.getBytes();                          // 获取字节
            MessageDigest mdTemp = MessageDigest.getInstance("MD5"); // 获取MD1
            mdTemp.update(strTemp);                                // 更新数据
            byte[] md = mdTemp.digest();                        // 加密
            int j = md.length;                                 // 加密后的长度
            char str[] = new char[j * 2];                       // 新字符串数组
            int k = 0;                                         // 计数器k
            for (int i = 0; i < j; i++) {                       // 循环输出
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);                             // 加密后字符串
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * @Auther cdu bbxiao
     * @Description: 更新cookie信息
     * @params: [request]
     * @return: void
     * @Date: 2019/8/28 22:41
     * @Modified By: bbxiao
     */
    public void updateCookie(HttpServletRequest request) {

        //初始化cookie变量
        boolean status = false;
        String account = null;
        String ssid = null;

        //查询cookie提取相关信息
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                //如果有cookie名为account
                if (cookie.getName().equals("account")) {
                    account = cookie.getValue();
                }
                //如果有cookie名为ssid
                if (cookie.getName().equals("ssid")) {
                    ssid = cookie.getValue();
                }
            }
        }
        //验证并更新cookie信息
        if (account != null && ssid != null) {
            status = ssid.equals(userUtil.calcMD1(account));
            if (status) {
                Cookie accountCookie = new Cookie("account", account);
                Cookie ssidCookie = new Cookie("ssid", ssid);
                accountCookie.setMaxAge(15 * 60);
                ssidCookie.setMaxAge(15 * 60);
            }
        }

    }

}
