package game;

import entity.Player;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class InputManager {
    public static void bindKeys(JComponent comp, Player player) {
        InputMap im = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = comp.getActionMap();

        im.put(KeyStroke.getKeyStroke("pressed W"), "up");
        im.put(KeyStroke.getKeyStroke("released W"), "stopUp");
        im.put(KeyStroke.getKeyStroke("pressed S"), "down");
        im.put(KeyStroke.getKeyStroke("released S"), "stopDown");
        im.put(KeyStroke.getKeyStroke("pressed A"), "left");
        im.put(KeyStroke.getKeyStroke("released A"), "stopLeft");
        im.put(KeyStroke.getKeyStroke("pressed D"), "right");
        im.put(KeyStroke.getKeyStroke("released D"), "stopRight");

        am.put("up", new AbstractAction() {
            public void actionPerformed(ActionEvent e) { player.setUp(true); }
        });
        am.put("stopUp", new AbstractAction() {
            public void actionPerformed(ActionEvent e) { player.setUp(false); }
        });
        am.put("down", new AbstractAction() {
            public void actionPerformed(ActionEvent e) { player.setDown(true); }
        });
        am.put("stopDown", new AbstractAction() {
            public void actionPerformed(ActionEvent e) { player.setDown(false); }
        });
        am.put("left", new AbstractAction() {
            public void actionPerformed(ActionEvent e) { player.setLeft(true); }
        });
        am.put("stopLeft", new AbstractAction() {
            public void actionPerformed(ActionEvent e) { player.setLeft(false); }
        });
        am.put("right", new AbstractAction() {
            public void actionPerformed(ActionEvent e) { player.setRight(true); }
        });
        am.put("stopRight", new AbstractAction() {
            public void actionPerformed(ActionEvent e) { player.setRight(false); }
        });
    }
}

