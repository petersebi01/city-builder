/* Péter Sebestyén */

package projekt.AbstractFactory;

import java.awt.*;

public interface Road {

    public boolean isSelected();
    public void setSelected(boolean selected);
    public void setRoadtype(Roadtype roadtype);
    public int getHeight();
    public int getWidth();
    public void draw(Graphics g, int x, int y);
}
