package com.jobs.management.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class TracePerformanceAspect {

	@Around("execution(* com.techshard..*.*(..)))")
	public Object logTracePerformanceAspect(ProceedingJoinPoint joinPoint) throws Throwable {

		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		// Get intercepted method details
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();

		long start = System.currentTimeMillis();

		Object result = joinPoint.proceed();
		long end = System.currentTimeMillis();

		// Log method execution time
		log.info("Execution time of " + className + "." + methodName + " :: " + (end - start) + " ms");

		return result;
	}
}
