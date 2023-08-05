package org.emeraldcraft.engine.api;

import lombok.SneakyThrows;

import java.lang.reflect.Method;

/**
 * Performs init tasks for the engine.
 */
public class GameStarter {
    private static boolean started = false;

    /**
     * Should be the first call in your main method.
     */
    @SneakyThrows
    public static void start(){
        if(started) return;
        Class<?> gameEngineClass = Class.forName("org.emeraldcraft.engine.impl.GameEngine");

        // Get the method of the GameEngine class that takes no arguments
        Method initMethod = gameEngineClass.getDeclaredMethod("init");
        initMethod.invoke(null);
        started = true;
    }
}
