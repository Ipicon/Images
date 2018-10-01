import edu.duke.*;
import java.io.*;
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public ImageResource makeGrey(ImageResource ir) {
        ImageResource newImage = new ImageResource(ir.getWidth() , ir.getHeight());
        for(Pixel pixel : newImage.pixels()) { 
                Pixel newPixel = ir.getPixel(pixel.getX(),pixel.getY());
                int ave = (newPixel.getRed() + newPixel.getGreen() + newPixel.getBlue()) / 3;
                pixel.setRed(ave);
                pixel.setGreen(ave);
                pixel.setBlue(ave);
        }
        return newImage;
    }
    public void selectAndSave() {
        DirectoryResource dr = new DirectoryResource();
        for(File f : dr.selectedFiles()) {
            ImageResource image = new ImageResource(f);
            ImageResource greyImage = makeGrey(image);
            String copyName = ("grey-" + f.getName());
            greyImage.setFileName(copyName);
            greyImage.draw();
            greyImage.save();
        }
    }
}
