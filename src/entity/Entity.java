package entity;

import java.awt.*;

public abstract class Entity {
    protected int x, y;
    protected int width = 32, height = 32;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void update();

    public abstract void draw(Graphics g);

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getX() { return x; }
    public int getY() { return y; }
}

