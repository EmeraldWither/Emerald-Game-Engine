package org.emeraldcraft.engine.impl;

import org.emeraldcraft.engine.api.internal.GameInstance;

public class GameEngine {
    public static void init(){
        GameInstance.setManager(new GameManagerImpl());
    }
    public static GameManagerImpl getGameManager(){
        return ((GameManagerImpl) GameInstance.getGameManager());
    }
}
