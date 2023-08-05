package org.emeraldcraft.engine.api;

import org.emeraldcraft.engine.api.gameobjects.GameObject;
import org.emeraldcraft.engine.api.internal.GameInstance;
import org.emeraldcraft.engine.api.scheduler.TaskScheduler;

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
    public List<GameObject> getGameObjects(){
        return new ArrayList<>(GameInstance.getGameManager().getGameObjects());
    }
}
