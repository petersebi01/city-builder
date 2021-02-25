/* Péter Sebestyén */

package projekt.Flyweight;

import java.awt.*;

public interface Building {

    public int getQuantity();
    public void setQuantity();
    public int getPrice();
    public int getTax();
    public int getMonthlyCost();
    public int getPopulation();
    public void setPopulation();
    public void setSelected(boolean b);
    public void draw(Graphics g, int x, int y);
}
