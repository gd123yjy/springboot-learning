package repository.imp;

import org.springframework.beans.factory.annotation.Qualifier;
import repository.MyRepository;

/**
 * Created by yjy on 16-12-16.
 */

public class MyRepositoryImp implements MyRepository {

    private String message;

    public MyRepositoryImp(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
