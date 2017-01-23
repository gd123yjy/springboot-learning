package aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import repository.imp.AdditionalRepositoryImp;
import repository.AdditionalRepositoryInterface;

/**
 * Created by yjy on 2017/1/23.
 */

@Aspect
public class LoggingAspect {

    private Log logger = LogFactory.getLog(this.getClass());

    @Before(value = "execution(* service.MyService.doMyService())")
    public void ReportRepositoryClassNameBeforeMyServiceCalled(){
        logger.debug("MyService is called");
    }

    @AfterReturning(value = "execution(* repository.imp.*.*(..))")
    public void LogAfterRepositoryMethodReturn(){
        logger.debug("Repository method is returned");
    }

    @Around(value = "execution(* repository.imp.MyRepositoryImp.*(..))",argNames = "joinPoint")
    public void AroundMyRepositoryImp(ProceedingJoinPoint joinPoint){
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.debug("MyRepositoryImp's method throws exception!");
        }
    }

    @DeclareParents(value = "repository.MyRepository+",defaultImpl = AdditionalRepositoryImp.class)
    public static AdditionalRepositoryInterface additionalRepositoryInterface;
}
