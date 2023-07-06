package org.emeraldcraft.engine.api;

import lombok.SneakyThrows;

import java.lang.reflect.Method;

public class GameStarter {
    private static boolean started = false;
    @SneakyThrows
    public static void start(){
        if(started) return;
        Class<?> gameEngineClass = Class.forName("org.emeraldcraft.engine.impl.GameEngine");

        // Get the constructor of the GameEngine class that takes no arguments
        Method initMethod = gameEngineClass.getDeclaredMethod("init");
        initMethod.invoke(null);
    }
}
