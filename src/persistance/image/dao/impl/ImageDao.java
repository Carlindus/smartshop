package persistance.image.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import persistance.image.bean.ImageDo;
import persistance.image.dao.IImageDao;

/**
 * @author Ian
 *
 */
public class ImageDao implements IImageDao {

    private static IImageDao    instance   = null;
    private static final String PATH_IMAGE = "D:\\temp\\images_smartshop\\";

    public ImageDao() {
    }

    /**
     * @return
     */
    public IImageDao getInstance() {
        if (instance == null) {
            instance = new ImageDao();
        }
        return instance;
    }

    @Override
    public byte[] afficherImageProduit(String nomImage) {
        final String cheminImage = PATH_IMAGE + nomImage; // On construit le chemin de l'image
        System.out.println("@ImageDao --- path_image : " + cheminImage);
        final File file = new File(cheminImage); // On cr�er le fichier
        final byte[] imageBytes = new byte[(int) file.length()]; // On instancie un tableau de bit � la longueur du fichier
        try (final FileInputStream fis = new FileInputStream(file);) { // On esseai de r�cup�rer le fichier
            fis.read(imageBytes);
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return imageBytes;
    }

    @Override
    public boolean stockerImageDisqueDur(ImageDo imageDo) throws IOException {
        final String fileName = imageDo.getImageName();
        FileOutputStream fileOutStream = null;
        if (!fileName.equals("") && !(fileName == null)) {

            File fileToCreate = new File(PATH_IMAGE + fileName);
            if (!fileToCreate.exists())
                try {
                    // @SuppressWarnings("resource")
                    fileOutStream = new FileOutputStream(fileToCreate);
                    fileOutStream.write(imageDo.getImageData());
                    fileOutStream.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                    fileOutStream.close();
                }
        }
        return false;
    }

}
