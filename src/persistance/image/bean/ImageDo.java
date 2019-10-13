/**
 * 
 */
package persistance.image.bean;

import java.io.File;

/**
 * @author Ian
 *
 */
public class ImageDo {

    private String imageName;
    private byte[] imageData;
    
    /**
     * @return
     */
    public String getImageName() {
        return imageName;
    }
    
    /**
     * @param imageName
     */
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    
    /**
     * @return
     */
    public byte[] getImageData() {
        return imageData;
    }
    
    /**
     * @param imageData
     */
    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
    
    
}
