/* Péter Sebestyén */

package projekt.AbstractFactory;

public class DesertWorld implements WorldFactory {

    @Override
    public Map createMap() {
        return new Map(18,18);
    }

    @Override
    public Terrain createTerrain() {
        return new DesertTerrain();
    }

    @Override
    public Tree createTree() {
        return null;
    }

    @Override
    public Road createRoad(Roadtype roadtype) {
        return new DesertRoad(roadtype);
    }
}
