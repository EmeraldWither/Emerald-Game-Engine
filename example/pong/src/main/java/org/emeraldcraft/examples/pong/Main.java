package org.emeraldcraft.examples.pong;

import org.emeraldcraft.engine.api.GameStarter;

public class Main {
    public static void main(String[] args) {
        GameStarter.start();
        new PongGame().startGame();
    }
}
