package com.huaxun.smart.log;

import com.huaxun.smart.entity.system.SysLog;
import com.huaxun.smart.service.system.SysLogService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.sql.Timestamp;

@Aspect
public class LogOperationAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private SysLogService sysLogService;

    public LogOperationAspect()
    {
    }
    /**
     * 定义切入点对象表达式 execution
     * 注解参数 logOperation
     */
    /**
     * 切入点声明
     */
    @Pointcut("@annotation(systemLog)")
    public void handlePointCut(SystemLog systemLog){}

    /**
     * Before 增强。对handlePointCut进行before增强
     * @param joinPoint 被通知的对象的对象、参数。。。
     * @param systemLog 注解参数提取action Name
     */
    @Before(value="handlePointCut(systemLog)")
    public void handleBefore(JoinPoint joinPoint,SystemLog systemLog){
        try {
            SysLog log = new SysLog();
            log.setAccount(getUserName());
            log.setModule(systemLog.module());
            log.setMethods(systemLog.methods());
            Timestamp time=new Timestamp(System.currentTimeMillis());
            log.setActionTime(time);
            Subject subject = SecurityUtils.getSubject();
            log.setUserIp(subject.getSession().getHost().toString());
            log.setOperTime(time);
            log.setDescription(systemLog.description());
            sysLogService.save(log);
        } catch (Exception e) {
            logger.error("LogOperationAspect before... ",e);
        }
    }

    private String getUserName()
    {
        try
        {
            Subject subject = SecurityUtils.getSubject();
            String userName = subject.getPrincipal().toString();
            return userName;
        }
        catch (Exception e)
        {
            //logger.error("aop-before",e);
            return "unknown";
        }
    }

}
