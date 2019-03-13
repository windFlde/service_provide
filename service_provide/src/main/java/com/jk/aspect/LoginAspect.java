package com.jk.aspect;

import com.jk.bean.LoginLog;
import com.jk.bean.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Aspect
@Component
public class LoginAspect {

    @Resource
    private MongoTemplate mongoTemplate;

    @Pointcut("execution(* com.jk.service.impl.LoginServiceImpl.*(..))")
    public void pointCut(){
        System.out.println("进入切点");
    }

    @AfterReturning(pointcut = "pointCut()",returning = "rtv")
    public void AfterLogin(JoinPoint joinPoint, Object rtv){
        User user = (User)rtv;
        LoginLog loginLog = null;
        if (user!=null){
            loginLog=new LoginLog(user.getLoginacct(),"请求登录",new Date());
        }else{
            loginLog=new LoginLog(null,"账户不存在",new Date());
        }
        mongoTemplate.save(loginLog);
    }

}
