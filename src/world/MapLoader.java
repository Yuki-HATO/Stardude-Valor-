package world;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MapLoader {
    public static GameMap loadFromJson(String path) {
        try {
            InputStream is = MapLoader.class.getResourceAsStream(path);
            if (is == null) throw new RuntimeException("地图文件找不到：" + path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder jsonBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line.trim());
            }
            String json = jsonBuilder.toString();

            // 简单解析字段
            int width = parseInt(json, "\"width\":");
            int height = parseInt(json, "\"height\":");
            int tileSize = parseInt(json, "\"tileSize\":");
            int[][] tiles = parseTiles(json, width, height);

            return new GameMap(width, height, tileSize, tiles);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static int parseInt(String json, String key) {
        int index = json.indexOf(key);
        if (index == -1) return 0;
        int start = json.indexOf(":", index) + 1;
        int end = json.indexOf(",", start);
        if (end == -1) end = json.indexOf("}", start);
        return Integer.parseInt(json.substring(start, end).trim());
    }

    private static int[][] parseTiles(String json, int width, int height) {
        int[][] tiles = new int[height][width];
        int start = json.indexOf("\"tiles\":") + 8;
        int end = json.lastIndexOf("]");
        String tilesData = json.substring(start, end + 1);

        tilesData = tilesData.replaceAll("[\\[\\]\\s]", "");
        String[] numbers = tilesData.split(",");
        for (int i = 0; i < numbers.length; i++) {
            int row = i / width;
            int col = i % width;
            tiles[row][col] = Integer.parseInt(numbers[i]);
        }
        return tiles;
    }
}


