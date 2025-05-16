package world;

import java.awt.*;

public class GameMap {
    private int[][] tiles;
    private int tileSize;

    public GameMap(int width, int height, int tileSize, int[][] tiles) {
        this.tileSize = tileSize;
        this.tiles = tiles;
    }

    // 空地图构造方法
    public GameMap(int width, int height, int tileSize) {
        this(width, height, tileSize, new int[height][width]);
    }

    public void draw(Graphics g) {
        for (int y = 0; y < tiles.length; y++) {
            for (int x = 0; x < tiles[0].length; x++) {
                switch (tiles[y][x]) {
                    case 0 -> g.setColor(Color.GREEN); // 草地
                    case 1 -> g.setColor(Color.GRAY);  // 路
                    case 2 -> g.setColor(Color.BLUE);  // 水
                    default -> g.setColor(Color.BLACK); // 未知瓦片
                }
                g.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
            }
        }
    }

    public boolean isWalkable(int tileX, int tileY) {
        return tiles[tileY][tileX] == 0 || tiles[tileY][tileX] == 1;
    }

    public int getTileSize() {
        return tileSize;
    }

    public int[][] getTiles() {
        return tiles;
    }
}


