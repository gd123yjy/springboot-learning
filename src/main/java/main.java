import configuration.MyConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import repository.AdditionalRepositoryInterface;
import service.MyService;

/**
 * Created by yjy on 16-12-16.
 */

@SpringBootConfiguration
@EnableAutoConfiguration
@PropertySource("classpath:/myProperties.properties")
@Import(MyConfiguration.class)
//@SpringBootApplication
public class main {

    public static void main(String[] args){
        ApplicationContext applicationContext = SpringApplication.run(main.class,args);
        MyService myService = applicationContext.getBean(MyService.class);
        myService.doMyService();

        AdditionalRepositoryInterface additionalRepository = (AdditionalRepositoryInterface) applicationContext.getBean("myRepository_another");
        additionalRepository.introduceMyself();
    }
}
