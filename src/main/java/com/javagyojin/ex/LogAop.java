package com.javagyojin.ex;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String signatureStr =  joinPoint.getSignature().toShortString();
		//타겟 메서드의 signature 정보
		System.out.println(signatureStr + "메서드가 시작 되었습니다.");
		long st = System.currentTimeMillis();//메서드 호출전의 현재 시간
		
		try {
		Object obj = joinPoint.proceed();//타겟의 메서드 호출
		return obj;
		} finally {
			long et = System.currentTimeMillis();//메서드 호출후의 현재 시간
			System.out.println(signatureStr + "메서드가 종료되었습니다.");
			System.out.println(signatureStr + "메서드의 작업 실행시간 : " + (et-st) + " ms");
		}
		
	}
	
	
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("before Advice 실행!");
	}
	
	public void afterReturningAdvice(JoinPoint joinPoint) {
		System.out.println("after Returning Advice 실행!");
	}
	
	public void afterThrowAdvice(JoinPoint joinPoint) {
		System.out.println("after Throw Advice 실행!");
	}
	
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("after Advice 실행!");
	}

}
