package game;

import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow() {
        setTitle("Stardew Lite");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        GamePanel panel = new GamePanel();
        add(panel);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);
        panel.startGame(); // 启动主循环
    }
}

