package com.counsellorapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggerAspect {

	private static final Logger logger =LoggerFactory.getLogger(LoggerAspect.class);
	
	// return, type class-name.method name, args {dont add comma}
	
//	This will run for all methods in that class
//	@Before("execution(* com.counsellorapp.service.CounsellorServiceImplementation.* (..))") //this for all methods 
//	public void logMethodCall() {
//		logger.info("Counsellor Method Called");
//	}
	@Before("execution(* com.counsellorapp.service.CounsellorServiceImplementation.findAll (..)) || execution(* com.counsellorapp.service.CounsellorServiceImplementation.getCounsellor (..))") //this for all methods 
	public void logMethodCalled(JoinPoint jp) {
		logger.info("Method Called "+jp.getSignature().getName());
	}
	
	@AfterReturning("execution(* com.counsellorapp.service.CounsellorServiceImplementation.findAll (..)) || execution(* com.counsellorapp.service.CounsellorServiceImplementation.getCounsellor (..))") //this for all methods 
	public void logMethodExecuted(JoinPoint jp) {
		logger.info(" Method Executed "+jp.getSignature().getName());
	}
	
}
