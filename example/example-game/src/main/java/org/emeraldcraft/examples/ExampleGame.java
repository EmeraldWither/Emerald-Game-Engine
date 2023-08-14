package org.emeraldcraft.examples;

import org.emeraldcraft.engine.api.Game;
import org.emeraldcraft.engine.api.settings.GameSettingsBuilder;

public class ExampleGame extends Game {
    public ExampleGame() {
        super("Example Game", 1, new GameSettingsBuilder().setIsFullScreen(false).getSettings());
    }
    @Override
    public void init() {
        new BasicMovingBox();
        new ControllableCircle();
    }

    @Override
    public void onTick() {

    }
}
