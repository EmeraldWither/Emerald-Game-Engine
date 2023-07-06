package org.emeraldcraft.engine.impl;

import lombok.Getter;
import org.dyn4j.dynamics.Body;
import org.dyn4j.world.World;
import org.emeraldcraft.engine.api.Game;
import org.emeraldcraft.engine.api.gameobjects.GameObject;
import org.emeraldcraft.engine.api.internal.GameInstance;
import org.emeraldcraft.engine.api.internal.GameManager;
import org.emeraldcraft.engine.api.settings.GameSettings;
import org.emeraldcraft.engine.api.utils.Logger;
import org.emeraldcraft.engine.impl.physics.PhysicsEngine;

import java.util.ArrayList;

public class GameManagerImpl implements GameManager {
    private Game game;

    @Getter
    private RenderManager renderer;
    private boolean isRunning;

    @Getter
    private final ArrayList<GameObject> gameObjects = new ArrayList<>();
    //queues for the gameobjects to be modified
    @Getter
    private final ArrayList<GameObject> removeObjectsQueue = new ArrayList<>();
    @Getter
    private final ArrayList<GameObject> addObjectsQueue = new ArrayList<>();

    private PhysicsEngine physicsEngine;


    @Override
    public void startThread() {
        if(GameInstance.getGame() == null) throw new IllegalStateException("Main game instance has not been created yet.");
        this.game = GameInstance.getGame();

        Logger.log("Starting main thread with the following settings: \n" + game.getSettings());
        //Physics engine setup
        physicsEngine = new PhysicsEngine();
        physicsEngine.setupEngine();

        game.init();
        renderer = new RenderManager(this);
        isRunning = true;
        new Thread(() -> {
            //measure how long we are ticking for
            long lastTickTime;

            while (isRunning) {
                lastTickTime = System.currentTimeMillis();

                physicsEngine.tick();

                for (GameObject gameObject : addObjectsQueue) {
                    //add any game objects that needed to be added
                    if (gameObject.getRenderPriority() >= gameObjects.size()) gameObjects.add(gameObject);
                    else gameObjects.add(gameObject.getRenderPriority() - 1, gameObject);
                }
                //clear the object queue since we added all of them now
                addObjectsQueue.clear();

                //tick everything
                for (GameObject gameObject : gameObjects) {
                    gameObject.tick();
                    if (gameObject.shouldRemove()) gameObject.remove();
                }
                //Run after tick
                game.onTick();

                //queue removing any game objects
                gameObjects.removeAll(removeObjectsQueue);
                removeObjectsQueue.clear();


                //Tick calculations, and how long we should sleep for
                long timeElapsed = System.currentTimeMillis() - lastTickTime;
                if (timeElapsed > game.getSettings().getTickTime())
                    //spawn a warning in case we take too long to tick
                    Logger.warn("Is the main thread lagging? Thread took " + timeElapsed + "ms to successfully tick.");
                else {
                    try {
                        //noinspection BusyWait
                        Thread.sleep(game.getSettings().getTickTime() - timeElapsed);
                    } catch (InterruptedException e) {
                        Logger.warn("Failed to sleep the main thread. Crashing with stacktrace");
                        e.printStackTrace();
                        System.exit(-1);
                    }
                }
            }
            //and start it immediately
        }).start();
        renderer.start();
    }

    @Override
    public void endThread() {
        isRunning = false;
    }


    @Override
    public GameSettings getSettings(){
        return this.game.getSettings();
    }
    @Override
    public String getName(){
        return this.game.getName();
    }

    @Override
    public void registerGameObject(GameObject gameObject) {
        this.addObjectsQueue.add(gameObject);
    }

    @Override
    public void deRegisterGameObject(GameObject gameObject) {
        this.removeObjectsQueue.add(gameObject);
    }

    @Override
    public World<Body> getPhysicsWorld() {
        return this.physicsEngine.getWorld();
    }
}
