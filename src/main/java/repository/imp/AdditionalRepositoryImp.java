package repository.imp;

import repository.AdditionalRepositoryInterface;

/**
 * Created by yjy on 2017/1/23.
 */
public class AdditionalRepositoryImp implements AdditionalRepositoryInterface {

    @Override
    public void introduceMyself() {
        System.out.println("I'm " + getClass().getName());
    }
}
