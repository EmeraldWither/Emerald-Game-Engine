package org.emeraldcraft.examples;

import org.emeraldcraft.engine.api.GameStarter;

public class Main {
    public static void main(String[] args) {
        GameStarter.start();
        new ExampleGame().startGame();
    }
}
