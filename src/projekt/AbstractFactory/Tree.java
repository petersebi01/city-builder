/* Péter Sebestyén */

package projekt.AbstractFactory;

import java.awt.*;

public interface Tree {

    public void setLocation(Point location);
    public Point getLocation();
    public void draw(Graphics g, int x, int y);
}
