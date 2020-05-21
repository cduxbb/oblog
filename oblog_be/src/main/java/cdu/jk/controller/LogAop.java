package cdu.jk.controller;


import cdu.jk.entity.Log;
import cdu.jk.service.ILogService;
import cdu.jk.utils.UserUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
　　* @Description: aop日志切面类
　　* @throws
　　* @author DXZ1
　　* @date 2020/5/19 16:18
*/

@Component("logAop")
@Aspect
public class LogAop {
    @Autowired
    private ILogService logService;
    @Autowired
    private UserUtil userUtil;

    @Autowired
    private HttpServletRequest request;
    private String startTime;//访问的时间
    private Class executionClass; //访问的类
    private Method executionMethod;//获取访问的方法

    /**
    　　* @Description: 前置通知
       * @param jp
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/19 16:19
    */
    @Before("execution(* cdu.jk.controller.*.*(..))")
    public void doBefore(JoinPoint jp) {
        startTime = userUtil.getSystemDate();//获取开始时间
        executionClass = jp.getTarget().getClass();//获取访问的类
        //新方法
        executionMethod=((MethodSignature)jp.getSignature()).getMethod();
    }

    /**
    　　* @Description: 后置通知，进行日志存储操作
       * @param jp
    　　* @return
    　　* @throws
    　　* @author DXZ1
    　　* @date 2020/5/19 16:20
    */
    @After("execution(* cdu.jk.controller.*.*(..))")
    public void doAfter(JoinPoint jp) {
        String url="";
        //开始获取访问路径
        if(executionClass!=null && executionMethod != null && executionClass != LogAop.class){
            //获取类上的@RequestMapping的Value
            RequestMapping classAnnotation = (RequestMapping) executionClass.getAnnotation(RequestMapping.class);
            if(classAnnotation!=null){
                String[] classValue = classAnnotation.value();
                //获取方法上的@RequestMapping的Value
                RequestMapping methodAnnotation = executionMethod.getAnnotation(RequestMapping.class);
                if(methodAnnotation!=null){
                    String[] methodValue = methodAnnotation.value();
                    url=classValue[0]+methodValue[0];//得到最终路径
                    //获取ip
                    String ip = request.getRemoteAddr();
                    Log sysLog = new Log();
                    sysLog.setIp(ip);
                    sysLog.setVisitMethod("[类名]： "+executionClass.getName()+"   [方法名] : "+executionMethod.getName());
                    sysLog.setVisitUrl(url);
                    sysLog.setLogTime(startTime);
                    //存储日志数据
                    logService.saveLog(sysLog);
                }
            }
        }
    }
}
