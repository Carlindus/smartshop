package service.image;

/**
 * @author formation
 *
 */
public interface IImageService {

    /**
     * @param nomImage
     * @return
     */
    byte[] recoverImageData(final String nomImage);
}
