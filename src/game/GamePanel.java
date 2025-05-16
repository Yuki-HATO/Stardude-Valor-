package game;

import entity.Player;
import world.MapManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    public static final int TILE_SIZE = 32;
    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private GameLoop gameLoop;
    private Player player;
    private MapManager mapManager;

    public GamePanel() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);
        setFocusable(true);
        requestFocus();

        player = new Player(5 * TILE_SIZE, 5 * TILE_SIZE);
        mapManager = new MapManager();

        InputManager.bindKeys(this, player);
        gameLoop = new GameLoop(this);
    }

    public void startGame() {
        gameLoop.start();
    }

    public void update() {
        player.update();
        // 其他实体更新
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        mapManager.draw(g);
        player.draw(g);
    }

    public Player getPlayer() {
        return player;
    }
}
