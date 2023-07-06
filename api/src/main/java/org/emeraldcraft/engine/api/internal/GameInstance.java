package org.emeraldcraft.engine.api.internal;

import lombok.Getter;
import lombok.SneakyThrows;
import org.emeraldcraft.engine.api.Game;
import org.emeraldcraft.engine.api.utils.Logger;

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
        Logger.log("Set was called!");
        if(GameInstance.gameManager != null) throw new IllegalAccessException("This class should not be used.");
        GameInstance.gameManager = game;
    }


}
