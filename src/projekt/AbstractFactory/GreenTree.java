/* Péter Sebestyén */

package projekt.AbstractFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GreenTree implements Tree {

    private BufferedImage image;
    private Point location;

    public GreenTree(){

        try {
            image = ImageIO.read(new File("Textures\\Tree\\treeConiferShort.png"));
        } catch (IOException ioexp) {
            System.out.println(ioexp.getMessage());
        } catch (ArrayIndexOutOfBoundsException arr) {
            arr.printStackTrace();
            System.out.println(arr.getMessage());
        }

    }

    @Override
    public void setLocation(Point location){
        this.location = location;
    }

    @Override
    public Point getLocation(){
        return location;
    }

    @Override
    public void draw(Graphics g, int x, int y){

        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(image, x, y, null);
    }
}
