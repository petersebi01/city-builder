/* Péter Sebestyén */

package projekt.AbstractFactory;

public class GreenWorld implements WorldFactory{

    @Override
    public Map createMap(){
        return new Map(15, 15);
    }

    @Override
    public Terrain createTerrain() {
        return new GreenTerrain();
    }

    @Override
    public Tree createTree() {
        return new GreenTree();
    }

    @Override
    public Road createRoad(Roadtype roadtype) {
        return new GreenRoad(roadtype);
    }
}
