package org.emeraldcraft.engine.impl.scheduler.tasks;

import lombok.Getter;
import org.emeraldcraft.engine.impl.scheduler.GameTask;

public class DelayedGameTask extends GameTask {
    @Getter
    private final Runnable runnable;

    private final int delay;

    private int ticks = 0;
    private boolean finished = false;

    public DelayedGameTask(Runnable runnable, int delay) {
        this.runnable = runnable;
        this.delay = delay;
    }

    /**
     * Should run every game tick.
     */
    public void tick() {
        if(delay == ticks){
            running = true;
            runnable.run();
            running = false;
            finished = true;
        }
        ticks++;
    }

    @Override
    public boolean isFinished() {
        return finished;
    }
}
