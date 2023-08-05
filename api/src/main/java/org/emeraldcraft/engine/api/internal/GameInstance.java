package org.emeraldcraft.engine.api.internal;

import lombok.Getter;
import lombok.SneakyThrows;
import org.emeraldcraft.engine.api.Game;

/**
 * Internal.
 * NOT API
 */
public final class GameInstance {
    @Getter
    private static Game game;

    @Getter
    private static GameManager gameManager;
    @SneakyThrows
    public static void setGame(Game game){
        if(GameInstance.game != null) throw new IllegalAccessException("This class should not be used.");
        GameInstance.game = game;
    }

    @SneakyThrows
    public static void setManager(GameManager game){
        if(GameInstance.gameManager != null) throw new IllegalAccessException("This class should not be used.");
        GameInstance.gameManager = game;
    }


}
