package org.emeraldcraft.examples.game;

import org.emeraldcraft.engine.api.Game;
import org.emeraldcraft.engine.api.settings.GameSettingsBuilder;
import org.emeraldcraft.engine.api.utils.Logger;

public class ExampleGame extends Game {
    public ExampleGame() {
        super("Example Game", 1, new GameSettingsBuilder().setIsFullScreen(false).setWindowSizeX(900).setWindowSizeY(900).getSettings());
        Logger.log("Ahhh");
    }

    @Override
    public void init() {
        new Thing();
        Logger.log("Hello World!");
    }

    @Override
    public void onTick() {

    }
}
