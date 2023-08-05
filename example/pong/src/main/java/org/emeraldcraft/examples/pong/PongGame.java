package org.emeraldcraft.examples.pong;

import org.emeraldcraft.engine.api.Game;
import org.emeraldcraft.engine.api.settings.DebugSettings;

public class PongGame extends Game {
    public PongGame() {
        super("Pong", 1);
    }

    @Override
    public void init() {
        new Paddle(Paddle.PaddleSide.LEFT);
        new Paddle(Paddle.PaddleSide.RIGHT);
        new Ball();
        DebugSettings.SHOW_HITBOXES = true;
    }

    @Override
    public void onTick() {

    }
}
