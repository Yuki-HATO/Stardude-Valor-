package entity;

import java.awt.*;

public class Player extends Entity {
    private boolean up, down, left, right;
    private int speed = 2;

    public Player(int x, int y) {
        super(x, y);
        this.width = 32;
        this.height = 32;
    }

    @Override
    public void update() {
        if (up) y -= speed;
        if (down) y += speed;
        if (left) x -= speed;
        if (right) x += speed;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }
}


