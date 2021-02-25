/* Péter Sebestyén */

package projekt.Mediator;

import projekt.AbstractFactory.City;
import projekt.Flyweight.Building;
import projekt.Flyweight.Toolbar;

public class DrawingMediator implements Mediator {

    private City city;
    private Toolbar toolbar;
    private GameState gameState;

    public DrawingMediator(){

    }

    @Override
    public void registerCity(Component component){
        city = (City) component;
    }

    @Override
    public void registerToolbar(Component component){
        toolbar = (Toolbar) component;
    }

    @Override
    public void registerInfobar(Component component){
        gameState = (GameState) component;
    }

    @Override
    public void setSelectedBuilding(Building building){
        city.getBuilding(building);

    }

    @Override
    public void setBuildingsPopulation(){

        toolbar.setHousePoints();
        toolbar.increasePoints();
    }

    @Override
    public void calculateMoney(int moneySent){
        gameState.setMoney(moneySent);
    }

    @Override
    public int getCityTax() {
        int tax = toolbar.getTax();
        return tax;
    }

    @Override
    public int getCosts(){
        return toolbar.getMonthlyCostOfBuildings();
    }

    @Override
    public void setPopulation(int population) {
        gameState.setPopulation(population);
    }
}
