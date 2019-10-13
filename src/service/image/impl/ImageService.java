package service.image.impl;

import persistance.image.dao.IImageDao;
import persistance.image.dao.impl.ImageDao;
import service.image.IImageService;
import util.MyFactory;

/**
 * @author ian
 *
 */
public class ImageService implements IImageService {

    private static IImageService instance = null;
    
    private ImageService() {
        
    }
    
    /**
     * @return
     */
    public static IImageService getInstance() {
        if (instance == null) {
            instance = new ImageService();
        }
        return instance;
    }

    @Override
    public byte[] recoverImageData(final String nomImage) {

        final IImageDao imageDao = new ImageDao();
        System.out.println("IMAGE NAME 2 " + nomImage);
        final byte[] byteImage = imageDao.afficherImageProduit(nomImage);
        return byteImage;
    }

}
