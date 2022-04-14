package com.javagyojin.ex;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	
	public Object loggerAop(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String signatureStr =  joinPoint.getSignature().toShortString();
		//Ÿ�� �޼����� signature ����
		System.out.println(signatureStr + "�޼��尡 ���� �Ǿ����ϴ�.");
		long st = System.currentTimeMillis();//�޼��� ȣ������ ���� �ð�
		
		try {
		Object obj = joinPoint.proceed();//Ÿ���� �޼��� ȣ��
		return obj;
		} finally {
			long et = System.currentTimeMillis();//�޼��� ȣ������ ���� �ð�
			System.out.println(signatureStr + "�޼��尡 ����Ǿ����ϴ�.");
			System.out.println(signatureStr + "�޼����� �۾� ����ð� : " + (et-st) + " ms");
		}
		
	}
	
	
	public void beforeAdvice(JoinPoint joinPoint) {
		System.out.println("before Advice ����!");
	}
	
	public void afterReturningAdvice(JoinPoint joinPoint) {
		System.out.println("after Returning Advice ����!");
	}
	
	public void afterThrowAdvice(JoinPoint joinPoint) {
		System.out.println("after Throw Advice ����!");
	}
	
	public void afterAdvice(JoinPoint joinPoint) {
		System.out.println("after Advice ����!");
	}

}
