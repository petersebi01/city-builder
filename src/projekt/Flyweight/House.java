/* Péter Sebestyén */

package projekt.Flyweight;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class House implements Building {

    private int quantity;
    private int price;
    private int population;
    private BufferedImage img;
    private boolean isSelected;
    private int otherTypes;
    private int tax;
    private int monthlyCost;

    public House(){

        isSelected = false;
        price = 0;
        population = 0;
        tax = 0;
        monthlyCost = 0; // ennyibe kerül a városnak, hogy fentartsa az épületet.

        try {
            img = ImageIO.read(new File("Textures\\Building\\House.png"));
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("A textura nem toltheto be.");
        }
    }

    public void numberofOtherBuildingTypes(int buildingTypeCount){
        otherTypes = buildingTypeCount;
    }

    // Hány ilyen típusú épület van a pályán
    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setQuantity() {
        this.quantity += 1;
    }

    // Az épület ára
    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public int getTax(){
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

    @Override
    public void setPopulation() {
        this.population = otherTypes * quantity;

        tax = population * 5 * quantity;
        monthlyCost = 5 * quantity;
        System.out.println("Ház beirva");
    }

    @Override
    public void setSelected(boolean b) {
        isSelected = b;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.drawImage(img, x-10, y-25,115,80,null);
    }

}
