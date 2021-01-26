import org.aspectj.lang.annotation.*;

//multiple advices
@Aspect
public class LoggingAspect {

	@After("allGetters()")
	public void afterAdvice(){
		System.out.println("After Advice from Getters");
	}

	@AfterReturning("allSetters()")
	public void afterReturning(){
		System.out.println("After Returning from Setters");
	}

	@AfterThrowing("execution(public * getName())")
	public void afterThrowing(){
		System.out.println("After throwing from Triangle getName");
	}

	@Around("execution(public * getName())")
	public void aroundAdvices(){
		System.out.println("Around Advice ");
	}

	@Pointcut("execution(public * get*(..))")
	public void allGetters() { 
	}

	@Pointcut("execution(public * set*(..))")
	public void allSetters() {
	}

}