package org.emeraldcraft.examples.game;


import org.emeraldcraft.engine.api.GameStarter;

public class Main {
    public static void main(String[] args) {
        GameStarter.start();
        ExampleGame exampleGame = new ExampleGame();
        exampleGame.startGame();
    }
}
