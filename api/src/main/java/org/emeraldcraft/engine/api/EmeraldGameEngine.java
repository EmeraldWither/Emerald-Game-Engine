package org.emeraldcraft.engine.api;

import org.emeraldcraft.engine.api.internal.GameInstance;
import org.emeraldcraft.engine.api.scheduler.TaskScheduler;

public class EmeraldGameEngine {
    public static TaskScheduler getTaskScheduler(){
        return GameInstance.getGameManager().getTaskExecutor();
    }
}
