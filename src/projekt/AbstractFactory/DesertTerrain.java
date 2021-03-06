/* Péter Sebestyén */

package projekt.AbstractFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DesertTerrain implements Terrain{

    private BufferedImage img;
    private static final int TILE_HEIGHT = 64;
    private Shape sp;

    public DesertTerrain(){

        sp = null;

        try {
            img = ImageIO.read(new File("Textures\\Terrain\\desert.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Textura betöltése sikertelen volt");
        }
    }

    @Override
    public void makeShape(int x, int y) {
        AffineTransform at = new AffineTransform();
        at.translate(x + 50, y);
        at.rotate(Math.PI/4);
        sp = at.createTransformedShape(initPoly());

    }

    @Override
    public Shape getSp(){
        return sp;
    }

    @Override
    public Rectangle initPoly() {

        Rectangle rectangle = new Rectangle(40,40);
        return rectangle;
    }

    @Override
    public int getHeight(){
        return TILE_HEIGHT;
    }

    @Override
    public int getWidth(){
        return img.getWidth();
    }

    @Override
    public void draw(Graphics g, int x, int y){
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(img, x, y, null);
    }
}
