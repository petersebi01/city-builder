/* Péter Sebestyén */

package projekt.Flyweight;

import java.util.HashMap;

public class BuildingFlyweight {

    static HashMap<BuildingType, Building> buildingPool = new HashMap<BuildingType, Building>();

    public BuildingFlyweight(){

    }

    public static Building getFlywieght(BuildingType type){

        Building building = null;

        if (buildingPool.containsKey(type)) {
            building = buildingPool.get(type);
        } else {
            switch (type) {
                case HOUSE:
                    building = new House();
                    break;
                case SHOP:
                    building = new Shop();
                    break;
                case FACTORY:
                    building = new Factory();
                    break;
                case PARK:
                    building = new Park();
                    break;
                case TAVERN:
                    building = new Tavern();
                    break;
                case OFFICE:
                    building = new Office();
                    break;
            }

            buildingPool.put(type, building);
        }
        return building;
    }
}
