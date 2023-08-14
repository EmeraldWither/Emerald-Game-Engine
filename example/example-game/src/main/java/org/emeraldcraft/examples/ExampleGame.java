package org.emeraldcraft.examples;

import org.emeraldcraft.engine.api.EmeraldGameEngine;
import org.emeraldcraft.engine.api.Game;
import org.emeraldcraft.engine.api.settings.GameSettingsBuilder;
import org.emeraldcraft.examples.commands.CreateCommand;

public class ExampleGame extends Game {
    public ExampleGame() {
        super("Example Game", 2, new GameSettingsBuilder().setIsFullScreen(false).getSettings());
    }
    @Override
    public void init() {
        new BasicMovingBox();
        new ControllableCircle();
        //register our command listener

        EmeraldGameEngine.getCommandsAPI().registerCommand(
                "create",
                new CreateCommand()
        );
    }

    @Override
    public void onTick() {

    }
}
