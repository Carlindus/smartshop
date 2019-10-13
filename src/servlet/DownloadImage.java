/**
 * 
 */
package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.image.IImageService;
import util.MyFactory;

/**
 * @author Ian
 *
 */
public class DownloadImage extends HttpServlet{

    /**
     * 
     */
    private static final long serialVersionUID = -8689906592771070800L;

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.
     * HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {

        final String imageName = req.getParameter("file");
        final IImageService imageService = MyFactory.getInstance(IImageService.class);
       // System.out.println("IMG NAME" + imageName);
        final byte[] imageBytes = imageService.recoverImageData(imageName);
       // System.out.println("IMG BYTTTE" + imageBytes);
        resp.setContentType("image/jpg");
        resp.setContentLength(imageBytes.length);
        resp.getOutputStream().write(imageBytes);
    }
}
