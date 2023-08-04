package org.emeraldcraft.engine.impl.scheduler.tasks;

import org.emeraldcraft.engine.impl.scheduler.GameTask;

public class RepeatingGameTask extends GameTask {
    private final Runnable runnable;
    private final int delay;
    private final int period;

    private int tick = 0;

    public RepeatingGameTask(Runnable runnable, int delay, int period) {
        this.runnable = runnable;
        this.delay = delay;
        this.period = period;
    }

    @Override
    public void tick() {
        if(delay <= tick){
            int currentDelayedTick = tick - delay;
            if(currentDelayedTick % period == 0){
                runnable.run();
            }
        }
        tick++;
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
