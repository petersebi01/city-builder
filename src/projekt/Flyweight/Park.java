/* Péter Sebestyén */

package projekt.Flyweight;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Park implements Building {

    private int quantity;
    private int price;
    private int population;
    private BufferedImage img;
    private boolean isSelected;
    private int tax;
    private int monthlyCost;

    public Park(){

        quantity = 0;
        population = 0;
        price = 3000;
        isSelected = false;
        tax = 0;
        monthlyCost = 0; // ennyibe kerül a városnak, hogy fentartsa az épületet.

        try {
            img = ImageIO.read(new File("Textures\\Building\\Park.png"));
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
        System.out.println( quantity + " a lakosa");
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
        System.out.println( quantity + " a lakosa");
        if (quantity <= 5){
            switch (quantity){
                case 1:
                    population = 2;
                    break;
                case 2:
                    population = 8;
                    break;
                case 3:
                    population = 12;
                    break;
                case 4:
                    population = 13;
                case 5:
                    population = 14;
                    break;
            }
        } else {
            population++;
        }

        tax = 250 * quantity;

        monthlyCost = 98 * quantity;
    }

    // Visszaadja, hog ki van-e választva az épület a Toolbar-ban.

    @Override
    public void setSelected(boolean b) {
        isSelected = b;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(img, x-7, y-22,115,80,null);
    }
}
