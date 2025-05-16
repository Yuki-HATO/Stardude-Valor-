package entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EntityManager {
    private List<Entity> entities = new ArrayList<>();
    private Player player;

    public EntityManager(Player player) {
        this.player = player;
        addEntity(player); // 玩家也是一个实体
    }

    public void addEntity(Entity e) {
        entities.add(e);
    }

    public void updateAll() {
        for (Entity e : entities) {
            e.update();
        }
    }

    public void drawAll(Graphics g) {
        for (Entity e : entities) {
            e.draw(g);
        }
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public Player getPlayer() {
        return player;
    }
}

