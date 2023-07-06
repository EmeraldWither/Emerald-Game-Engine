package org.emeraldcraft.engine.impl;

import org.emeraldcraft.engine.api.internal.GameManager;
import org.emeraldcraft.engine.api.gameobjects.GameObject;
import org.emeraldcraft.engine.api.settings.DebugSettings;
import org.emeraldcraft.engine.api.utils.Logger;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RenderManager extends JComponent {
    private final GameManager game;
    private boolean isRunning = false;
    private JFrame gameFrame;

    public RenderManager(GameManager game) {
        this.game = game;
    }


    public JFrame getGameFrame() {
        return gameFrame;
    }

    @Override
    public void paintComponent(Graphics g) {
        paintGame(g);
    }

    public void switchToGame() {
        gameFrame = new JFrame();
        gameFrame.add(this);
        gameFrame.setName(game.getName());
        //load screen dimensions based on the game settings
        if (game.getSettings().isFullScreen()) {
            gameFrame.setUndecorated(true);
            gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        } else {
            gameFrame.setSize(game.getSettings().getWindowSizeX(), game.getSettings().getWindowSizeY());
        }
        gameFrame.setResizable(false);
        gameFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        gameFrame.setVisible(true);
    }

    public void paintGame(Graphics g) {
        ArrayList<GameObject> gameObjects = game.getGameObjects();
        //backwards loop so important items are painted last (first)
        for (int i = gameObjects.size() - 1; i >= 0; i--) {
            GameObject gameObject = gameObjects.get(i);
            gameObject.render(g);

            //see if we have to render hitboxes
            if (DebugSettings.SHOW_HITBOXES) {
                ((Graphics2D) g).setStroke(new BasicStroke(5));

                //render based on the hitbox and location of the gameobject
                g.setColor(Color.BLUE);
                g.drawRect(gameObject.getLocation().x, gameObject.getLocation().y, gameObject.getHitBox().getWidth(), gameObject.getHitBox().getHeight());
                g.setFont(new Font("Arial", Font.BOLD, 24));
                g.drawString("\"" + gameObject.getName() + "\"", gameObject.getLocation().x, gameObject.getLocation().y - 10);
                ((Graphics2D) g).setStroke(new BasicStroke(1));
            }
            g.setColor(Color.black);
        }
    }

    /**
     * Start this renderer
     */
    public void start() {
        if (isRunning) throw new IllegalStateException("The renderer has already been started and is running.");
        isRunning = true;

        Logger.log("Game Renderer has been initialized and is running.");
        switchToGame();
        new Thread(() ->
        {
            while (isRunning) {
                repaint();
            }
        }).start();
    }
}
