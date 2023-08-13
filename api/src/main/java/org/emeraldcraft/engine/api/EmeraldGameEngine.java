package org.emeraldcraft.engine.api;

import org.emeraldcraft.engine.api.commands.CommandExecutor;
import org.emeraldcraft.engine.api.gameobjects.GameObject;
import org.emeraldcraft.engine.api.internal.GameInstance;
import org.emeraldcraft.engine.api.scheduler.TaskScheduler;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Base API for the Emerald Game Engine.
 */
public class EmeraldGameEngine {
    public static TaskScheduler getTaskScheduler(){
        return GameInstance.getGameManager().getTaskExecutor();
    }

    /**
     * @return A copy of the list of all the registered gameobjects.
     */
    public static List<GameObject> getGameObjects(){
        return new ArrayList<>(GameInstance.getGameManager().getGameObjects());
    }

    public static <U extends GameObject> List<GameObject> getGameObjectsByType(Class<U> type){
        ArrayList<GameObject> gameObjects = new ArrayList<>();
        for (GameObject gameObject : GameInstance.getGameManager().getGameObjects()) {
            if(type.isInstance(gameObject)){
                gameObjects.add(gameObject);
            }
        }
        return gameObjects;
    }

    public static CommandExecutor getCommandsAPI() {
        return GameInstance.getGameManager().getCommandAPI();
    }

    public static Dimension getScreenSize(){
        return Toolkit.getDefaultToolkit().getScreenSize();
    }
}
