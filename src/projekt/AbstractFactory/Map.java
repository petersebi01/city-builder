/* Péter Sebestyén */

package projekt.AbstractFactory;

public class Map {

    private int[][] tileMap;

    public Map(int x, int y) {

        tileMap = new int[x][y];
        for (int i = 0; i < tileMap.length; i++) {
            for (int j = 0; j < tileMap.length; j++) {
                tileMap[i][j] = 0;
            }
        }
    }

    public void setTileMap(int value, int i, int j) {

        tileMap[i][j] = value;
    }

    public int[][] getTileMap() {
        return tileMap;
    }
}
