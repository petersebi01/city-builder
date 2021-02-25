/* Péter Sebestyén */

package projekt.AbstractFactory;

import java.awt.*;

public interface Terrain {

    public void makeShape(int x, int y);
    public Shape getSp();
    public Rectangle initPoly();
    public int getHeight();
    public int getWidth();
    public void draw(Graphics g, int x, int y);
}
