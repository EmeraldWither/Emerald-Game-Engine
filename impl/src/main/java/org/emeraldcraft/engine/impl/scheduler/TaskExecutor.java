package org.emeraldcraft.engine.impl.scheduler;

import org.emeraldcraft.engine.api.scheduler.Task;
import org.emeraldcraft.engine.api.scheduler.TaskScheduler;
import org.emeraldcraft.engine.impl.scheduler.tasks.DelayedGameTask;
import org.emeraldcraft.engine.impl.scheduler.tasks.RepeatingGameTask;

import java.util.ArrayList;

public class TaskExecutor implements TaskScheduler {
    private final ArrayList<GameTask> tasks = new ArrayList<>();
    private boolean internal = false;
    public void markNextTaskAsInternal(){
        internal = true;
    }

    @Override
    public Task scheduleDelayedTask(Runnable runnable, int delay) {
        DelayedGameTask gameTask = new DelayedGameTask(runnable, delay, internal);
        internal = false;
        tasks.add(gameTask);
        return gameTask;
    }

    @Override
    public Task scheduleRepeatingTask(Runnable runnable, int delay, int period) {
        RepeatingGameTask gameTask = new RepeatingGameTask(runnable, delay, period, internal);
        internal = false;
        tasks.add(gameTask);
        return gameTask;
    }
    public void executeTasks() {
        for (GameTask gameTask: new ArrayList<>(tasks)) {
            if(gameTask.isCancelled() || gameTask.isFinished()){
                tasks.remove(gameTask);
                continue;
            }
            gameTask.tick();
        }
    }

    public ArrayList<Task> getTasks() {
        return new ArrayList<>(tasks);
    }
}
