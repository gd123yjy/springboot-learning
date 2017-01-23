package service;

import org.springframework.beans.factory.annotation.Qualifier;
import repository.MyRepository;

/**
 * Created by yjy on 16-12-16.
 */
public class MyService {

    private MyRepository myResposity;

    public MyService(MyRepository myRepository) {
        this.myResposity = myRepository;
    }

    public void doMyService(){
        System.out.println(myResposity.getMessage());
    }
}
