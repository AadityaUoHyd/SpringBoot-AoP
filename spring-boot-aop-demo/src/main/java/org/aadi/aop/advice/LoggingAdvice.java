package org.aadi.aop.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAdvice {

	Logger log = LoggerFactory.getLogger(LoggingAdvice.class);
	
	@Pointcut(value="execution(* org.aadi.aop.*.*.*(..) )")
	public void myPointcut() {		
	}
	
	@Pointcut(value="execution(* org.aadi.aop.runner.PracticeAopRunner.run(..) )")
	public void runnerPointcut() {		
	}
	
	@Pointcut(value="execution(* org.aadi.aop.controller.ProductController.getProductById(..) )")
	public void errorPointcut() {		
	}
	
	@Before("runnerPointcut()")
	public void start() {
		System.out.println("\n AOP - @Before");
	}
	
	@After(value = "runnerPointcut()")
	public void end() {
		System.out.println("\n AOP - @After");
	}
	
	@AfterReturning(value = "errorPointcut()")
	public void noError() {
		System.out.println("\n AOP - @AfterReturning success");
	}
	
	@AfterThrowing(value = "errorPointcut()")
	public void gotError() {
		System.out.println("\n AOP - @AfterThrowing error");
	}
	
	@Around("myPointcut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] array = pjp.getArgs();
		log.info("method invoked " + className + " : " + methodName + "()" + "arguments : "
				+ mapper.writeValueAsString(array));
		Object object = pjp.proceed();
		log.info(className + " : " + methodName + "()" + "Response : "
				+ mapper.writeValueAsString(object));
		return object;
	}

}