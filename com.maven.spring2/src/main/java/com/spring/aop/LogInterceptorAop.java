package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogInterceptorAop {
	/*@Pointcut("execution(* com.spring..*.*(..))")
	public void method() {}
	
	@Before("method()")
	public void before()
	{
		System.out.println("method start");
	}
	
	@AfterReturning("method()")
	public void after()
	{
		System.out.println("method end");
	}*/
	/*@AfterThrowing("execution(* com.spring..*.*(..))")
	public void after()
	{
		System.out.println("throw exception");
	}*/
	/*@Around("execution(* com.spring..*.*(..))")
	public void around(ProceedingJoinPoint pjp) throws Throwable
	{
		System.out.println("around start");
		pjp.proceed();
		System.out.println("around end");
	}*/
	public void before()
	{
		System.out.println("method start");
	}
}
