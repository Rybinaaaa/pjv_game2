package main.Model;

import main.Model.Tiles.Magma;
import main.Model.Tiles.RockyRoad;
import main.Model.Tiles.Tile;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Map {
    private Tile mapMatrix[][];

    private String background;

    private static class Level {
        String mapSrc;
        String bacgroundSrc;

        public String getMapSrc() {
            return mapSrc;
        }

        public String getBackgroundSrc() {
            return bacgroundSrc;
        }

        public Level(String mapSrc, String bacgroundSrc) {
            this.mapSrc = mapSrc;
            this.bacgroundSrc = bacgroundSrc;
        }
    }

    Level[] levels = new Level[]{
            new Level("/res/maps/map1.txt", "/res/backgrounds/Background1.png")
    };

    int maxScreenRow, maxScreenColumn;

    public Tile getTileOption(int option) {
        switch (option) {
            case 0:
                return null;
            case 1:
                return new RockyRoad();
            case 2:
                return new Magma();
            default:
                return new RockyRoad();
        }
    }

    ;


    private void loadMap(String src) {
        try {
            InputStream is = getClass().getResourceAsStream(src);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int option;

            for (int i = 0; i < maxScreenRow; i++) {
//                System.out.println("1");

                String row = br.readLine();
                String[] numbers = row.split(" ");
                for (int j = 0; j < maxScreenColumn; j++) {
                    option = Integer.parseInt(numbers[j]);
//                    System.out.println("2");
                    if (option == 0) {
                        continue;
                    }
                    mapMatrix[i][j] = getTileOption(option);
                    mapMatrix[i][j].setX(48 * j);
                    mapMatrix[i][j].setY(48 * i);
//                    System.out.println("---" + mapMatrix[i][j]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public Tile[][] getMapMatrix() {
//        return mapMatrix;
//    }

    public void setMapMatrix(int index) {
        try {
            loadMap(levels[index - 1].getMapSrc());
        } catch (Exception e) {
            e.printStackTrace();
        }
//        return getMapMatrix();
    }

    public Tile getTile(int x, int y) {
        return mapMatrix[y / 48][x / 48];
    }
    public Tile[][] getMapMatrix() {
        return mapMatrix;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(int index) {
        this.background = levels[index - 1].getBackgroundSrc();
    }

    public Map(int maxScreenRow, int maxScreenColumn) {
        this.maxScreenColumn = maxScreenColumn;
        this.maxScreenRow = maxScreenRow;
        this.mapMatrix = new Tile[maxScreenRow][maxScreenColumn];
        setMapMatrix(1);
        setBackground(1);
    }
}
