import java.security.NoSuchAlgorithmException;

import persistance.cgu.dao.ICguDao;
import persistance.cgu.dao.impl.CguDao;
import util.MD5;
import util.MyFactory;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        
        ICguDao dao = MyFactory.getInstance(ICguDao.class);
        System.out.println(dao.readCgu());
    }

}
