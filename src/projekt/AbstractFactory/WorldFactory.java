/* Péter Sebestyén */

package projekt.AbstractFactory;

public interface WorldFactory {

    public Map createMap();
    public Terrain createTerrain();
    public Tree createTree();
    public Road createRoad(Roadtype roadtype);
}
