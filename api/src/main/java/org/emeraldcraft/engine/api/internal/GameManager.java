package org.emeraldcraft.engine.api.internal;

import org.emeraldcraft.engine.api.gameobjects.GameObject;
import org.emeraldcraft.engine.api.scheduler.TaskScheduler;
import org.emeraldcraft.engine.api.settings.GameSettings;

import java.util.ArrayList;

/**
 * Internal.
 * NOT API
 */
public interface GameManager {
    void startThread();

    ArrayList<GameObject> getAddObjectsQueue();

    ArrayList<GameObject> getRemoveObjectsQueue();

    ArrayList<GameObject> getGameObjects();

    void endThread();

    GameSettings getSettings();

    String getName();

    void registerGameObject(GameObject gameObject);

    void deRegisterGameObject(GameObject gameObject);

    TaskScheduler getTaskExecutor();
}
