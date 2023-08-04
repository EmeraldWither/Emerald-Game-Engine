package org.emeraldcraft.examples;

import org.emeraldcraft.engine.api.Game;

public class ExampleGame extends Game {
    public ExampleGame() {
        super("Example Game", 1);
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
