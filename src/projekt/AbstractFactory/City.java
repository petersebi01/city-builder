/* Péter Sebestyén */

package projekt.AbstractFactory;

import projekt.Flyweight.Building;
import projekt.Mediator.Component;
import projekt.Mediator.Mediator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class City extends JPanel implements Component, MouseListener {

    private int money;
    private int population;
    private Map map;
    private int[][] tileMap;
    private WorldFactory worldFactory;
    private Terrain[][] terrain;
    private Road[][] road;
    private Mediator mediator;
    private ArrayList<Building> building;
    private Building selectedBuilding;

    public City(Mediator mediator){

        money = 1000;
        population = 0;
        this.mediator = mediator;
        building = new ArrayList<>();
        this.addMouseListener(this);
        selectedBuilding = null;
    }

    public void createNewWorld(WorldFactory worldFactory){
        this.worldFactory = worldFactory;
        map = worldFactory.createMap();
        tileMap = map.getTileMap();
        terrain = new Terrain[tileMap.length][tileMap.length];
        road = new Road[tileMap.length][tileMap.length];

        //int id = 0;

        int ex = 0;
        int ey = 0;
        Random random = new Random();

        for (int i = 1; i < tileMap.length - 1; i++) {
            for (int j = 1; j < tileMap[i].length - 1; j++) {
                //id++;
                if (tileMap[i][j] == 0) {
                    terrain[i][j] = worldFactory.createTerrain();

                    if (terrain[i][j].getClass().getSimpleName().equals("GreenTerrain")) {
                        ex = (j * terrain[i][j].getWidth() / 2) + (i * terrain[i][j].getWidth() / 2) + 50;
                        ey = (i * terrain[i][j].getHeight() / 2) - (j * terrain[i][j].getHeight() / 2) + 500;

                        int n = 0;
                        while (n < 4) {

                            int x = random.nextInt(100);
                            int y = random.nextInt(10);
                            Tree tree = worldFactory.createTree();
                            tree.setLocation(new Point(ex + x, ey + y));

                            if (terrain[i][j].getClass().getSimpleName().equals("GreenTerrain")) {
                                GreenTerrain greenTerrain = (GreenTerrain) terrain[i][j];
                                greenTerrain.addTree(tree);
                            }
                            n++;
                        }
                    }
                }

            }
        }
    }

    @Override
    public int getTax() {
        return  0;
    }

    public int getMonthlyCostOfBuildings(){
        return 0;
    }

    @Override
    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public void setPopulation(int population) {
        this.population = population;

    }

    public void getBuilding(Building building){

        if (building != null) {
            this.building.add(building);
        }
        selectedBuilding = building;
    }

    @Override
    public void paintComponent(Graphics g) {

        Graphics2D graphics2D = (Graphics2D) g;
        super.paintComponent(g);

        int ey = 0;
        int ex = 0;

        for (int i = 1; i < tileMap.length - 1; i++) {
            for (int j = tileMap[i].length - 2; j >= 1; j--) {

                if (tileMap[i][j] == 3) {
                    ex = (j * road[i][j].getWidth() / 2) + (i * road[i][j].getWidth() / 2) + 50;
                    ey = (i * road[i][j].getHeight() / 2) - (j * road[i][j].getHeight() / 2) + 500;

                    road[i][j].draw(graphics2D, ex, ey);

                } else {

                    ex = (j * terrain[i][j].getWidth() / 2) + (i * terrain[i][j].getWidth() / 2) + 50;
                    ey = (i * terrain[i][j].getHeight() / 2) - (j * terrain[i][j].getHeight() / 2) + 500;

                    terrain[i][j].draw(graphics2D, ex, ey);
                    terrain[i][j].makeShape(ex, ey);

                    if (terrain[i][j].getClass().getSimpleName().equals("GreenTerrain")) {
                        GreenTerrain greenTerrain = (GreenTerrain) terrain[i][j];
                        for (Tree t : greenTerrain.getTrees()) {
                            t.draw(graphics2D, t.getLocation().x, t.getLocation().y);
                        }
                    }

                    if (tileMap[i][j] == 4) {
                        for (Building b : building) {
                            if (b.getClass().getSimpleName().equals("House"))
                                b.draw(graphics2D, ex, ey);
                        }
                    }
                    if (tileMap[i][j] == 5) {
                        for (Building b : building) {
                            if (b.getClass().getSimpleName().equals("Shop"))
                                b.draw(graphics2D, ex, ey);
                        }
                    }
                    if (tileMap[i][j] == 6) {
                        for (Building b : building) {
                            if (b.getClass().getSimpleName().equals("Office"))
                                b.draw(graphics2D, ex, ey);
                        }
                    }
                    if (tileMap[i][j] == 7) {
                        for (Building b : building) {
                            if (b.getClass().getSimpleName().equals("Tavern"))
                                b.draw(graphics2D, ex, ey);
                        }
                    }
                    if (tileMap[i][j] == 8) {
                        for (Building b : building) {
                            if (b.getClass().getSimpleName().equals("Factory"))
                                b.draw(graphics2D, ex, ey);
                        }
                    }
                    if (tileMap[i][j] == 9) {
                        for (Building b : building) {
                            if (b.getClass().getSimpleName().equals("Park"))
                                b.draw(graphics2D, ex, ey);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (selectedBuilding == null) {

            for (int i = 1; i < tileMap.length - 1; i++) {
                for (int j = 1; j < tileMap[i].length - 1; j++) {
                    if (tileMap[i][j] == 0) {
                        if (terrain[i][j].getSp().contains(mx, my)) {
                            map.setTileMap(3, i, j);
                            tileMap = map.getTileMap();
                            road[i][j] = worldFactory.createRoad(Roadtype.setRoadType(map, i, j));
                        }
                    }

                    if (tileMap[i][j] == 3) {
                        road[i][j].setRoadtype(Roadtype.setRoadType(map, i, j));
                    }
                }
            }
        } else {
            for (int i = 1; i < tileMap.length - 1; i++) {
                for (int j = 1; j < tileMap[i].length - 1; j++) {
                    if (tileMap[i][j] == 0 && terrain[i][j].getSp().contains(mx, my)) {

                        switch (selectedBuilding.getClass().getSimpleName()) {
                            case "House":
                                map.setTileMap(4, i, j);
                                break;
                            case "Shop":
                                map.setTileMap(5, i, j);
                                break;
                            case "Office":
                                map.setTileMap(6, i, j);
                                break;
                            case "Tavern":
                                map.setTileMap(7, i, j);
                                break;
                            case "Factory":
                                map.setTileMap(8, i, j);
                                break;
                            case "Park":
                                map.setTileMap(9, i, j);
                                break;
                        }

                    } // if vége

                } // for vége
            } // for vége

            mediator.setBuildingsPopulation();
        }

        repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
