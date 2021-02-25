/* Péter Sebestyén */

package projekt.Flyweight;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tavern implements Building {

    private int quantity;
    private int price;
    private int population;
    private BufferedImage img;
    private boolean isSelected;
    private int tax;
    private int monthlyCost;

    public Tavern(){

        quantity = 0;
        population = 0;
        price = 2500;
        tax = 0;
        isSelected = false;
        monthlyCost = 0; // ennyibe kerül a városnak, hogy fentartsa az épületet.

        try {
            img = ImageIO.read(new File("Textures\\Building\\Tavern.png"));

        } catch (IOException e){
            e.printStackTrace();
            System.out.println("A textura nem toltheto be.");
        }
        System.out.println(img.getWidth() + "  " + img.getHeight());
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

        if (quantity <= 4){
            switch (quantity){
                case 1:
                    population = 1;
                    break;
                case 2:
                    population = 4;
                    break;
                case 3:
                    population = 9;
                    break;
                case 4:
                    population = 17;
                    break;
            }
        } else {
            population += 3;
        }

        tax = (800 + population) * quantity;

        monthlyCost = 875 * quantity;
    }

    // Visszaadja, hog ki van-e választva az épület a Toolbar-ban.

    @Override
    public void setSelected(boolean b) {
        isSelected = b;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(img, x-3, y-14, 105,70,null);
    }
}
