/* Péter Sebestyén */

package projekt.Flyweight;

import projekt.Mediator.Component;
import projekt.Mediator.Mediator;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Toolbar extends JPanel implements Component, MouseListener {

    private JButton tavernBtn;
    private JButton officeBtn;
    private JButton houseBtn;
    private JButton shopBtn;
    private JButton parkBtn;
    private JButton factoryBtn;
    private JButton roadBtn;
    private Mediator mediator;
    private Building selectedBuilding;

    public Toolbar(Mediator mediator){

        this.mediator = mediator;
        selectedBuilding = null;

        try {
            BufferedImage tavernIcon = ImageIO.read(new File("Textures\\Building\\Tavern.jpg"));
            BufferedImage officeIcon = ImageIO.read(new File("Textures\\Building\\Office.jpg"));
            BufferedImage houseIcon = ImageIO.read(new File("Textures\\Building\\House.jpg"));
            BufferedImage shopIcon = ImageIO.read(new File("Textures\\Building\\Shop.jpg"));
            BufferedImage parkIcon = ImageIO.read(new File("Textures\\Building\\Park.jpg"));
            BufferedImage factoryIcon = ImageIO.read(new File("Textures\\Building\\Factory.jpg"));
            try {
                BufferedImage roadIcon = ImageIO.read(new File("Textures\\Road\\GreenRoad\\Straight\\roadNorth.png"));

                roadBtn = new JButton(new ImageIcon(roadIcon));
                roadBtn.setBorder(BorderFactory.createEmptyBorder());
                roadBtn.setContentAreaFilled(false);
            }catch (IOException e){

                try {
                    BufferedImage roadIcon = ImageIO.read(new File("Textures\\Road\\DesertRoad\\Straight\\roadNorth.png"));

                    roadBtn = new JButton(new ImageIcon(roadIcon));
                    roadBtn.setBorder(BorderFactory.createEmptyBorder());
                    roadBtn.setContentAreaFilled(false);
                } catch (IOException e1){
                    e1.getMessage();
                    System.out.println("A textura betöltése sikertelen volt");
                }
            }

            tavernBtn = new JButton(new ImageIcon(tavernIcon));
            tavernBtn.setBorder(BorderFactory.createEmptyBorder());
            tavernBtn.setContentAreaFilled(false);

            officeBtn = new JButton(new ImageIcon(officeIcon));
            officeBtn.setBorder(BorderFactory.createEmptyBorder());
            officeBtn.setContentAreaFilled(false);

            houseBtn = new JButton(new ImageIcon(houseIcon));
            houseBtn.setBorder(BorderFactory.createEmptyBorder());
            houseBtn.setContentAreaFilled(false);

            shopBtn = new JButton(new ImageIcon(shopIcon));
            shopBtn.setBorder(BorderFactory.createEmptyBorder());
            shopBtn.setContentAreaFilled(false);

            parkBtn = new JButton(new ImageIcon(parkIcon));
            parkBtn.setBorder(BorderFactory.createEmptyBorder());
            parkBtn.setContentAreaFilled(false);

            factoryBtn = new JButton(new ImageIcon(factoryIcon));
            factoryBtn.setBorder(BorderFactory.createEmptyBorder());
            factoryBtn.setContentAreaFilled(false);

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setLayout(new GridLayout(7,1));

        this.add(tavernBtn);
        this.add(officeBtn);
        this.add(houseBtn);
        this.add(shopBtn);
        this.add(parkBtn);
        this.add(factoryBtn);
        this.add(roadBtn);

        tavernBtn.addMouseListener(this);
        officeBtn.addMouseListener(this);
        houseBtn.addMouseListener(this);
        shopBtn.addMouseListener(this);
        parkBtn.addMouseListener(this);
        factoryBtn.addMouseListener(this);
        roadBtn.addMouseListener(this);
    }

    public Building getSelectedBuilding(){
        selectedBuilding.setQuantity();
        return selectedBuilding;
    }

    public int calculatePopulation(){

        int population = 0;
        for (HashMap.Entry entry : BuildingFlyweight.buildingPool.entrySet()){
            Building building = (Building) entry.getValue();
            population += building.getPopulation();
        }

        return population;
    }

    public int calculateMoney(){

        int population = 0;
        for (HashMap.Entry entry : BuildingFlyweight.buildingPool.entrySet()){
            Building building = (Building) entry.getValue();
            population += building.getPrice();
        }

        return population;
    }

    public void increasePoints(){
        selectedBuilding.setQuantity();
        System.out.println(selectedBuilding.getQuantity() + " a mennyiség");
        selectedBuilding.setPopulation();
        setMoney(selectedBuilding.getPrice());
        setPopulation(calculatePopulation());
        System.out.println(selectedBuilding.getPopulation() + " vége");
    }

    public void setHousePoints(){
        House house = (House) BuildingFlyweight.getFlywieght(BuildingType.HOUSE);
        house.numberofOtherBuildingTypes(BuildingFlyweight.buildingPool.size());
        house.setPopulation();
        System.out.println(BuildingFlyweight.buildingPool.get(0) + " a tipusk szama");
        System.out.println(house.getPopulation() + " eleje");
    }

    @Override
    public int getTax() {
        int m = 0;

        for (BuildingType b : BuildingType.values()) {
            if (BuildingFlyweight.buildingPool.get(b) != null)
                m += BuildingFlyweight.buildingPool.get(b).getTax();
        }
        return m;
    }

    @Override
    public int getMonthlyCostOfBuildings() {
        int m = 0;

        for (BuildingType b : BuildingType.values()) {
            if (BuildingFlyweight.buildingPool.get(b) != null)
                m += BuildingFlyweight.buildingPool.get(b).getMonthlyCost();
        }
        return m;
    }

    @Override
    public void setMoney(int moneySent) {
        mediator.calculateMoney(moneySent);
    }

    @Override
    public void setPopulation(int population) {
        mediator.setPopulation(population);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource().equals(tavernBtn)){
            Building building = BuildingFlyweight.getFlywieght(BuildingType.TAVERN);
            System.out.println("Tavern selected");
            if (selectedBuilding == null) {
                building.setSelected(true);
                selectedBuilding = building;
            } else {
                selectedBuilding.setSelected(false);
                building.setSelected(true);
                selectedBuilding = building;
            }

            mediator.setSelectedBuilding(selectedBuilding);
        }
        if (e.getSource().equals(officeBtn)){
            System.out.println("Office selected");
            Building building = BuildingFlyweight.getFlywieght(BuildingType.OFFICE);
            if (selectedBuilding == null){
                building.setSelected(true);
                selectedBuilding = building;
            } else {
                selectedBuilding.setSelected(false);
                building.setSelected(true);
                selectedBuilding = building;
            }

            mediator.setSelectedBuilding(selectedBuilding);
        }
        if (e.getSource().equals(houseBtn)){
            Building building = BuildingFlyweight.getFlywieght(BuildingType.HOUSE);
            System.out.println("House selected");
            if (selectedBuilding == null) {
                building.setSelected(true);
                selectedBuilding = building;
            } else {
                selectedBuilding.setSelected(false);
                building.setSelected(true);
                selectedBuilding = building;
            }

            mediator.setSelectedBuilding(selectedBuilding);
        }
        if (e.getSource().equals(shopBtn)){
            System.out.println("Shop selected");
            Building building = BuildingFlyweight.getFlywieght(BuildingType.SHOP);
            if (selectedBuilding == null) {
                building.setSelected(true);
                selectedBuilding = building;
            } else {
                selectedBuilding.setSelected(false);
                building.setSelected(true);
                selectedBuilding = building;
            }

            mediator.setSelectedBuilding(selectedBuilding);
        }
        if (e.getSource().equals(parkBtn)){
            System.out.println("Park selected");
            Building building = BuildingFlyweight.getFlywieght(BuildingType.PARK);
            if (selectedBuilding == null) {
                building.setSelected(true);
                selectedBuilding = building;
            } else {
                selectedBuilding.setSelected(false);
                building.setSelected(true);
                selectedBuilding = building;
            }

            mediator.setSelectedBuilding(selectedBuilding);
        }
        if (e.getSource().equals(factoryBtn)){
            System.out.println("Factory selected");
            Building building = BuildingFlyweight.getFlywieght(BuildingType.FACTORY);
            if (selectedBuilding == null) {
                building.setSelected(true);
                selectedBuilding = building;
            } else {
                selectedBuilding.setSelected(false);
                building.setSelected(true);
                selectedBuilding = building;
            }

            mediator.setSelectedBuilding(selectedBuilding);
        }
        if (e.getSource().equals(roadBtn)){
            System.out.println("Road selected");

            if (selectedBuilding != null) {
                selectedBuilding.setSelected(false);
                selectedBuilding = null;
            }
            mediator.setSelectedBuilding(selectedBuilding);
        }

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
