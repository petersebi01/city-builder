/* Péter Sebestyén */

package projekt.AbstractFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DesertRoad implements Road{

    private BufferedImage img;
    private static final int TILE_HEIGHT = 64;
    private boolean isSelected;
    private int id;
    private Shape sp;

    public DesertRoad(Roadtype roadtype){

        isSelected = false;
        sp = null;

        setRoadtype(roadtype);
    }

    @Override
    public void setRoadtype(Roadtype roadtype){

        switch (roadtype) {

            //Egyenes út
            case STRAIGHTEAST:
                try {
                    img = ImageIO.read(new File("Textures\\Road\\DesertRoad\\Straight\\roadEast.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                    e.getCause();
                    System.out.println("Az ut textera nem töltheto be!");
                }
                break;
            case STRAIGHTNORTH:
                try {
                    img = ImageIO.read(new File("Textures\\Road\\DesertRoad\\Straight\\roadNorth.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                    e.getCause();
                    System.out.println("Az ut textera nem töltheto be!");
                }
                break;

            //Kanyar
            case TURN_ES:
                try {
                    img = ImageIO.read(new File("Textures\\Road\\DesertRoad\\Turn\\roadCornerES.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                    e.getCause();
                    System.out.println("Az ut textera nem töltheto be!");
                }
                break;
            case TURN_NE:
                try {
                    img = ImageIO.read(new File("Textures\\Road\\DesertRoad\\Turn\\roadCornerNE.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                    e.getCause();
                    System.out.println("Az ut textera nem töltheto be!");
                }
                break;
            case TURN_NW:
                try {
                    img = ImageIO.read(new File("Textures\\Road\\DesertRoad\\Turn\\roadCornerNW.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                    e.getCause();
                    System.out.println("Az ut textera nem töltheto be!");
                }
                break;
            case TURN_WS:
                try {
                    img = ImageIO.read(new File("Textures\\Road\\DesertRoad\\Turn\\roadCornerWS.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                    e.getCause();
                    System.out.println("Az ut textera nem töltheto be!");
                }
                break;

            // T útelágazás
            case T_ROAD_NORHT:
                try {
                    img = ImageIO.read(new File("Textures\\Road\\DesertRoad\\RoadT\\roadTNorth.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                    e.getCause();
                    System.out.println("Az ut textera nem töltheto be!");
                }
                break;
            case T_ROAD_WEST:
                try {
                    img = ImageIO.read(new File("Textures\\Road\\DesertRoad\\RoadT\\roadTWest.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                    e.getCause();
                    System.out.println("Az ut textera nem töltheto be!");
                }
                break;
            case T_ROAD_EAST:
                try {
                    img = ImageIO.read(new File("Textures\\Road\\DesertRoad\\RoadT\\roadTEast.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                    e.getCause();
                    System.out.println("Az ut textera nem töltheto be!");
                }
                break;
            case T_ROAD_SOUTH:
                try {
                    img = ImageIO.read(new File("Textures\\Road\\DesertRoad\\RoadT\\roadTSouth.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                    e.getCause();
                    System.out.println("Az ut textera nem töltheto be!");
                }
                break;

            //Zsákutca
            case ROAD_END_NORTH:
                try {
                    img = ImageIO.read(new File("Textures\\Road\\DesertRoad\\RoadEnd\\roadEndNorth.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                    e.getCause();
                    System.out.println("Az ut textera nem töltheto be!");
                }
                break;
            case ROAD_END_EAST:
                try {
                    img = ImageIO.read(new File("Textures\\Road\\DesertRoad\\RoadEnd\\roadEndEast.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                    e.getCause();
                    System.out.println("Az ut textera nem töltheto be!");
                }
                break;
            case ROAD_END_SOUTH:
                try {
                    img = ImageIO.read(new File("Textures\\Road\\DesertRoad\\RoadEnd\\roadEndSouth.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                    e.getCause();
                    System.out.println("Az ut textera nem töltheto be!");
                }
                break;
            case ROAD_END_WEST:
                try {
                    img = ImageIO.read(new File("Textures\\Road\\DesertRoad\\RoadEnd\\roadEndWest.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                    e.getCause();
                    System.out.println("Az ut textera nem töltheto be!");
                }
                break;

            //Útkeresztezödés
            case CROSSROAD:
                try {
                    img = ImageIO.read(new File("Textures\\Road\\DesertRoad\\Crossroad\\Crossroad.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                    e.getCause();
                    System.out.println("Az ut textera nem töltheto be!");
                }
                break;
        }
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public void setSelected(boolean selected) {
        isSelected = selected;
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
