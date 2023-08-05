package org.emeraldcraft.engine.api;

import lombok.Getter;
import org.emeraldcraft.engine.api.internal.GameInstance;
import org.emeraldcraft.engine.api.settings.GameSettings;
import org.emeraldcraft.engine.api.settings.GameSettingsBuilder;
import org.emeraldcraft.engine.api.utils.Logger;

/**
 * Represents a Game.
 */
public abstract class Game {
    @Getter
    private final String name;
    @Getter
    private final int version;
    @Getter
    private GameSettings settings = new GameSettingsBuilder().getSettings();



    public Game(String name, int version) {
        this.name = name;
        this.version = version;
        GameInstance.setGame(this);
    }

    public Game(String name, int version, GameSettings gameSettings) {
        this.name = name;
        this.version = version;
        this.settings = gameSettings;
        GameInstance.setGame(this);
    }

    public abstract void init();

    /**
     * This method will run after all of the gameobjects tick.
     */
    public abstract void onTick();

    /**
     * Should only be called once.
     */
    public void startGame(){
        Logger.log("Starting " + name + " v" + version);
        GameInstance.getGameManager().startThread();
    }
}
