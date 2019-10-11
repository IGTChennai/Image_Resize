package ImageResize;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImageTest {

	private static final int IMG_WIDTH = 200;    // Enter the Image Width Here
    private static final int IMG_HEIGHT = 200;   // Enter the Image Height Here
    
    public static void main(String [] args){
            
    try{
            // Enter the Source Image Path here//         
            BufferedImage originalImage = ImageIO.read(new File("c:\\New folder\\6.jpg"));
            int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
            
            // Enter the converted JPG Image save Path here// 
            BufferedImage resizeImageJpg = resizeImage(originalImage, type);
            ImageIO.write(resizeImageJpg, "jpg", new File("c:\\New folder\\6_jpg.jpg")); 
            
            // Enter the converted PNG Image save Path here// 
            BufferedImage resizeImagePng = resizeImage(originalImage, type);
            ImageIO.write(resizeImagePng, "png", new File("c:\\New folder\\6_png.jpg")); 
                                      
    }catch(IOException e){
            System.out.println(e.getMessage());
    }
            
}
    
private static BufferedImage resizeImage(BufferedImage originalImage, int type){
    BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
    Graphics2D g = resizedImage.createGraphics();
    g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
    g.dispose();
            
    return resizedImage;
}

}
