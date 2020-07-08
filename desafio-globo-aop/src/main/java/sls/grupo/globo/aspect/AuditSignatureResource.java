package sls.grupo.globo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sls.grupo.globo.anotation.AuditExecutionTime;
import sls.grupo.globo.service.AuditSignatureService;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class AuditSignatureResource {

    @Autowired
    AuditSignatureService auditSignatureService;

    @Pointcut(value = "execution(public * *(..))")
    public void anyPublicMethod() {}

    @Before("anyPublicMethod() && @annotation(auditExecutionTime) && args(..,request)")
    public void logBefore(JoinPoint joinPoint, AuditExecutionTime auditExecutionTime, HttpServletRequest request){
        this.auditSignatureService.setInputParameter(joinPoint);
    }

    @AfterReturning(pointcut = "anyPublicMethod() && @annotation(auditExecutionTime) && args(..,request)", returning = "result")
    public void logAfter(JoinPoint joinPoint, AuditExecutionTime auditExecutionTime, HttpServletRequest request,
                         Object result){
        this.auditSignatureService.save();
    }
}
