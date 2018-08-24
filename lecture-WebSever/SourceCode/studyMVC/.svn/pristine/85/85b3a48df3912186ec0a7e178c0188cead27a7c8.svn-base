package kr.or.nextit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NextServiceAdvise {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	/**
	 * 타겟 메서드 실행 전 수행
	 * 
	 * @param joinPoint
	 */
	public void beforeMethod(JoinPoint joinPoint) {

		System.out.println("====================== 실행 =======================");
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		log.debug(">>> beforeMethod 실행: {}.{}", className, methodName);

		Object[] args = joinPoint.getArgs();

		if (args != null) {
			for (Object oj : args) {
				log.debug(">>> 파라미터 정보 = {}", oj.toString());
			}
		}
		System.out.println("====================== 종료 =======================");
	}

	/**
	 * 실행 전 처리, 타겟 메서드 직접 호출, 예외처리 가능
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("====================== 실행 =======================");
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();
		log.debug(">>> beforeMethod 실행: {}.{}", className, methodName);

		long startTime = System.currentTimeMillis();

		Object retVal = null;

		Object[] args = joinPoint.getArgs();

		if (args != null) {
			for (Object oj : args) {
				log.debug(">>> aroundMethod 파라미터 정보 = {}", oj.toString());
			}
		}

		try {
			retVal = joinPoint.proceed(); // ;;;대상 객체 실행 (없으면 에러)
			log.debug("retVal: {}", retVal);
		} catch (Exception e) {
			retVal = new String("***오류발생" + e.getMessage());
		} finally {
			log.debug(">>> aroundMethod load time = {}", (System.currentTimeMillis() - startTime));
			System.out.println("====================== 종료 =======================");
		}

		return retVal;
	}

	public void retMethod(JoinPoint joinPoint, Object ret) {
		System.out.println("====================== 실행 =======================");
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getSimpleName();

		Object[] args = joinPoint.getArgs();

		// ;파라미터 값 확인
		if (args != null) {
			for (Object oj : args) {
				log.debug(">>> retMethod 파라미터 정보 = {}", oj.toString());
			}
		}

		log.debug("retMethod 실행: {}.{}", className, methodName);
		log.debug(">>> 실행결과 정보 = {}", ret);

		System.out.println("====================== 종료 =======================");

	}

}
