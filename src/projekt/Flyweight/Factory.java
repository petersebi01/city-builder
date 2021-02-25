/* Péter Sebestyén */

package projekt.Flyweight;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Factory implements Building {

    private int quantity;
    private int price;
    private int population;
    private BufferedImage img;
    private boolean isSelected;
    private int tax;
    private int monthlyCost;

    public Factory(){

        isSelected = false;
        quantity = 0;
        population = 0;
        price = 5000;
        tax = 0;
        monthlyCost = 0; // ennyibe kerül a városnak, hogy fentartsa az épületet.

        try {
            img = ImageIO.read(new File("Textures\\Building\\Factory.png"));
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("A textura nem toltheto be.");
        }
    }

    // Hány ilyen típusú épület van a pályán
    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity() {
        quantity += 1;
    }

    // Az épület ára
    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getTax() {
        return tax;
    }

    @Override
    public int getMonthlyCost() {
        return monthlyCost;
    }

    // Visszatéríti, hogy hány lakóssal bővíti a város népességét
    @Override
    public int getPopulation() {
        return population;
    }

    public void setPopulation() {

        if (population != 0) {
            population = population * quantity;
        } else {
            population = 2;
        }

        if (quantity < 3) {
            tax = 2500 * quantity;
            monthlyCost = 500 * quantity;
        } else {
            tax = 1500 * quantity;
            monthlyCost = 1000 * quantity;
        }
    }

    // Visszaadja, hog ki van-e választva az épület a Toolbar-ban.
    @Override
    public void setSelected(boolean b) {
        isSelected = b;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(img, x+7, y-20,90,65,null);
    }
}
