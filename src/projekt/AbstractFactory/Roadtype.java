/* Péter Sebestyén */

package projekt.AbstractFactory;

public enum Roadtype {
    STRAIGHTNORTH,
    STRAIGHTEAST,
    TURN_ES,
    TURN_NE,
    TURN_NW,
    TURN_WS,
    T_ROAD_EAST,
    T_ROAD_NORHT,
    T_ROAD_SOUTH,
    T_ROAD_WEST,
    ROAD_END_NORTH,
    ROAD_END_EAST,
    ROAD_END_SOUTH,
    ROAD_END_WEST,
    CROSSROAD;

    // visszatéríti a megfelelö út textúrát
    public static Roadtype setRoadType(Map map, int i, int j){

        if (map.getTileMap()[i][j] == 3) {
            if (map.getTileMap()[i + 1][j] != 3 && map.getTileMap()[i - 1][j] != 3 && map.getTileMap()[i][j + 1] != 3 && map.getTileMap()[i][j - 1] != 3){
                return STRAIGHTNORTH;
            }
            if ((map.getTileMap()[i + 1][j] == 3 || map.getTileMap()[i - 1][j] == 3) && map.getTileMap()[i][j - 1] != 3 && map.getTileMap()[i][j + 1] != 3) {
                return STRAIGHTNORTH;
            }
            if ((map.getTileMap()[i][j + 1] == 3 || map.getTileMap()[i][j - 1] == 3) && map.getTileMap()[i - 1][j] != 3 && map.getTileMap()[i + 1][j] != 3) {
                return STRAIGHTEAST;
            }
            if (map.getTileMap()[i - 1][j] == 3 && map.getTileMap()[i][j + 1] == 3 && map.getTileMap()[i + 1][j] != 3 && map.getTileMap()[i][j - 1] != 3) {
                return TURN_NE;
            }
            if (map.getTileMap()[i - 1][j] == 3 && map.getTileMap()[i][j - 1] == 3 && map.getTileMap()[i + 1][j] != 3 && map.getTileMap()[i][j + 1] != 3) {
                return TURN_NW;
            }
            if (map.getTileMap()[i + 1][j] == 3 && map.getTileMap()[i][j + 1] == 3 && map.getTileMap()[i - 1][j] != 3 && map.getTileMap()[i][j - 1] != 3) {
                return TURN_ES;
            }
            if (map.getTileMap()[i + 1][j] == 3 && map.getTileMap()[i][j - 1] == 3 && map.getTileMap()[i - 1][j] != 3 && map.getTileMap()[i][j + 1] != 3) {
                return TURN_WS;
            }
            if (map.getTileMap()[i + 1][j] == 3 && map.getTileMap()[i - 1][j] == 3 && map.getTileMap()[i][j + 1] == 3 && map.getTileMap()[i][j - 1] != 3) {
                return T_ROAD_EAST;
            }
            if (map.getTileMap()[i + 1][j] == 3 && map.getTileMap()[i - 1][j] == 3 && map.getTileMap()[i][j - 1] == 3 && map.getTileMap()[i][j + 1] != 3) {
                return T_ROAD_WEST;
            }
            if (map.getTileMap()[i - 1][j] == 3 && map.getTileMap()[i][j - 1] == 3 && map.getTileMap()[i][j + 1] == 3 && map.getTileMap()[i + 1][j] != 3) {
                return T_ROAD_NORHT;
            }
            if (map.getTileMap()[i + 1][j] == 3 && map.getTileMap()[i][j - 1] == 3 && map.getTileMap()[i][j + 1] == 3 && map.getTileMap()[i - 1][j] != 3) {
                return T_ROAD_SOUTH;
            }
            if (map.getTileMap()[i + 1][j] == 3 && map.getTileMap()[i - 1][j] == 3 && map.getTileMap()[i][j + 1] == 3 && map.getTileMap()[i][j - 1] == 3) {
                return CROSSROAD;
            }
        }
        return null;
    }
}
