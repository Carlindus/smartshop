package service.cgu.impl;

import persistance.cgu.dao.ICguDao;
import service.cgu.ICguService;
import util.MyFactory;

/**
 * @author Caroline
 *
 */
public class CguService implements ICguService {

    /**
     * @return
     */
    public static CguService getInstance() {
        return new CguService();
    }

    /*
     * (non-Javadoc)
     * 
     * @see service.cgu.ICguService#readCgu()
     */
    @Override
    public String readCgu() {
      final ICguDao cgu = MyFactory.getInstance(ICguDao.class);
      final String str = cgu.readCgu();
      System.out.println("STR = " + str);
       return str;
    }

}
