package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspect {
	
	//	To write specifically for point class write om.au.aop.model.Point.getX()
	
	@Before("execution(public String getName())")
	public void LoggingAdvice() {
		System.out.println("Logging Advice");
	}
	
	
	//Apply before all methods start with get
	//execution(public * get*(*) - with parameter
	//execution(public * get*(..) - with any number of parameters
	//execution(* com.au.aop.model.*.get*()) - all get functions for class under model
	@Before("execution(public * get*())")
	public void LoggingAdvice2() {
		System.out.println("Logging Advice");
		
	}
	
	
	@Before("allGetters()")
	public void SecondAdvice() {
		System.out.println("Method Invoked BEFORE all Getters");
		
	}
	
	//Define pointcut expression
	@Pointcut("execution(public * get*(..))")
	public void allGetters() { 
		/* this is a dummy method for holding pointcut expressions, so they can be referenced later in annotations @Before etc */
	}

	// SpringAssignment_q2
	
	@Before("execution(public String model.Circle.getName())")
	public void LoggingAdviceCircle() {
		System.out.println("Circle getName Advice");
	}

	@Before("execution(public String model.Triangle.getName())")
	public void LoggingAdviceTriangle() {
		System.out.println("Triangle getName Advice");
	}

	// After
	@After("allGetters()")
	public void AfterGetter() {
		System.out.println("Method Invoked AFTER all Getters");
	}
	
	// Around
	@Pointcut("execution (public * set*(..))")
	private void allSet() {}
	
	@Around("allSet()")
	public void aroundAdvice() {
		System.out.println("Before entering and after exiting the Setter");
	}
	
	
	// AfterThrowing 
	@AfterThrowing(pointcut = "execution( public * *(..))", throwing = "error")
	public void afterThrowingAdvice() {
		System.out.println("Exception thrown");
	}

	// After returning Annotation
	@AfterReturning(pointcut="execution( public * *(..))", returning = "retVal")
	public void afterReturning(Object retVal) {
		System.out.println("Method Invoked after Returning");
	} 
	

}
