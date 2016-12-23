package repository.imp;

import org.springframework.beans.factory.annotation.Qualifier;
import repository.MyRepository;

/**
 * Created by yjy on 16-12-16.
 */

public class MyRepositoryImp_another implements MyRepository {

    private String message;

    public MyRepositoryImp_another(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
