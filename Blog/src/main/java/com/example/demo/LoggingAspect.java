package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	 @Pointcut("execution(* com.example.demo.BlogController.*(..))")
	    public void blogControllerMethods() {}

	    @Before("blogControllerMethods()")
	    public void logBefore(JoinPoint joinPoint) {
	        System.out.println("➡️ Entering method: " + joinPoint.getSignature().getName());
	    }

	    @AfterReturning(pointcut = "blogControllerMethods()", returning = "result")
	    public void logAfterReturning(JoinPoint joinPoint, Object result) {
	        System.out.println("✅ Method executed: " + joinPoint.getSignature().getName());
	        if (result != null) {
	            System.out.println("Result: " + result);
	        }
	    }

	    @AfterThrowing(pointcut = "blogControllerMethods()", throwing = "error")
	    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
	        System.out.println("❌ Exception in method: " + joinPoint.getSignature().getName());
	        System.out.println("Error: " + error.getMessage());
	    }
}
