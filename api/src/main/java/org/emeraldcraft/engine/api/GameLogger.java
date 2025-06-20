package org.emeraldcraft.engine.api;

import org.emeraldcraft.engine.api.internal.GameInstance;

public class GameLogger {
    public static void log(String s) {
        GameInstance.getGameManager().getLogger().log(s);
    }
}
