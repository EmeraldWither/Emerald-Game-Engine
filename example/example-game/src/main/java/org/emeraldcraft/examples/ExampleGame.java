package org.emeraldcraft.examples;

import org.emeraldcraft.engine.api.Game;
import org.emeraldcraft.engine.api.settings.GameSettingsBuilder;

public class ExampleGame extends Game {
    public ExampleGame() {
        super("Example Game", 1, new GameSettingsBuilder().setIsFullScreen(false).setWindowSizeX(600).setWindowSizeY(600).getSettings());
    }

    @Override
    public void init() {
        new BasicMovingBox();
    }

    @Override
    public void onTick() {

    }
}
