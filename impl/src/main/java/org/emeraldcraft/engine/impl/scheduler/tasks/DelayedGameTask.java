package org.emeraldcraft.engine.impl.scheduler.tasks;

import lombok.Getter;
import org.emeraldcraft.engine.impl.scheduler.GameTask;

public class DelayedGameTask extends GameTask {
    @Getter
    private final Runnable runnable;

    private final int delay;
    private final boolean internal;

    private int ticks = 0;
    private boolean finished = false;

    public DelayedGameTask(Runnable runnable, int delay, boolean internal) {
        this.runnable = runnable;
        this.delay = delay;
        this.internal = internal;
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

    @Override
    public String toString() {
        if(internal) return "InternalGameTask (Not USER)";
        return "DelayedGameTask{" +
                "delay=" + delay +
                ", finished=" + finished +
                ", cancelled=" + cancelled +
                ", running=" + running +
                '}';
    }
}
