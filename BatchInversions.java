import edu.duke.*;
import java.io.*;
/**
 * Write a description of BatchInversions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BatchInversions {
    public ImageResource makeInversion (ImageResource ir) {
        ImageResource newImage = new ImageResource(ir.getWidth() , ir.getHeight());
        for(Pixel pixel : newImage.pixels()) { 
                Pixel newPixel = ir.getPixel(pixel.getX(),pixel.getY());
                pixel.setRed(255-newPixel.getRed());
                pixel.setGreen(255-newPixel.getGreen());
                pixel.setBlue(255-newPixel.getBlue());
        }
        return newImage;
    }
    public void selectAndSave() {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            ImageResource image = new ImageResource(f);
            ImageResource greyImage = makeInversion(image);
            String copyName = ("inverteed-" + f.getName());
            greyImage.setFileName(copyName);
            greyImage.draw();
            greyImage.save();
        }
    }
}
