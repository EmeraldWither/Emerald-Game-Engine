package org.emeraldcraft.examples;

import org.emeraldcraft.engine.api.EmeraldGameEngine;
import org.emeraldcraft.engine.api.Game;
import org.emeraldcraft.engine.api.settings.GameSettingsBuilder;
import org.emeraldcraft.examples.commands.CreateCommand;
import org.emeraldcraft.examples.customevents.CircleListener;

public class ExampleGame extends Game {
    public ExampleGame() {
        super("Example Game", 2, new GameSettingsBuilder().setIsFullScreen(false).setGravityMeterScaling(1).getSettings());
    }
    @Override
    public void init() {
        new BasicMovingBox();
        new ControllableCircle();
        new GravityBox();
        //register our command listener

        EmeraldGameEngine.getCommandsAPI().registerCommand(
                "create",
                new CreateCommand()
        );
        EmeraldGameEngine.getEventsManager().registerListener(new CircleListener());
    }

    @Override
    public void onTick() {

    }
}
