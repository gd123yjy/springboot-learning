package configuration;

import aspect.LoggingAspect;
import condition.MyCondition;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import repository.MyRepository;
import repository.imp.MyRepositoryImp;
import repository.imp.MyRepositoryImp_another;
import service.MyService;

/**
 * Created by yjy on 16-12-16.
 */

@EnableAspectJAutoProxy
@Configuration
public class MyConfiguration {

    @Bean
    public MyService myService(@Qualifier("priority2") MyRepository myRepository){
        return new MyService(myRepository);
    }

    @Bean
    @Qualifier("priority1")
    @Conditional(MyCondition.class)
    public MyRepository myRepository_one(@Value("${myRepository.message}") String message){
        return new MyRepositoryImp(message);
    }

    @Bean
    @Qualifier("priority2")
    @Conditional(MyCondition.class)
    public MyRepository myRepository_another(@Value("${myRepository.message2}") String message){
        return new MyRepositoryImp_another(message);
    }

    @Bean
    public LoggingAspect loggingAspect(){
        return new LoggingAspect();
    }
}
