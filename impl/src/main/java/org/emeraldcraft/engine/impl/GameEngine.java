package org.emeraldcraft.engine.impl;

import lombok.extern.java.Log;
import org.emeraldcraft.engine.api.internal.GameInstance;
import org.emeraldcraft.engine.api.utils.Logger;

public class GameEngine {
    public static void init(){
        GameInstance.setManager(new GameManagerImpl());
    }
}
