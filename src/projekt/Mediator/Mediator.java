/* Péter Sebestyén */

package projekt.Mediator;

import projekt.Flyweight.Building;

public interface Mediator {

    public void registerCity(Component component);
    public void registerToolbar(Component component);
    public void registerInfobar(Component component);
    public int getCityTax();
    public int getCosts();
    public void calculateMoney(int moneySent);
    public void setPopulation(int population);
    public void setBuildingsPopulation();
    public void setSelectedBuilding(Building building);

}
