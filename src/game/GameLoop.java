package game;

public class GameLoop extends Thread {
    private static final int FPS = 60;
    private final GamePanel panel;

    public GameLoop(GamePanel panel) {
        this.panel = panel;
    }

    @Override
    public void run() {
        long interval = 1000 / FPS;

        while (true) {
            long start = System.currentTimeMillis();

            panel.update();
            panel.repaint();

            long elapsed = System.currentTimeMillis() - start;
            long sleep = interval - elapsed;
            if (sleep < 0) sleep = 2;

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

