package persistance.image.dao;

import java.io.IOException;

import persistance.image.bean.ImageDo;

/**
 * @author Ian
 *
 */
public interface IImageDao {

    /**
     * @param nomImage
     * @return
     */
    byte[] afficherImageProduit(final String nomImage);
    /**
     * @param imageDo
     * @return
     * @throws IOException 
     * @throws Exception 
     */
    boolean stockerImageDisqueDur(final ImageDo imageDo) throws IOException;
}
