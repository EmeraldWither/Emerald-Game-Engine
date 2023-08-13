package org.emeraldcraft.engine.impl.scheduler.tasks;

import org.emeraldcraft.engine.impl.scheduler.GameTask;

public class RepeatingGameTask extends GameTask {
    private final Runnable runnable;
    private final int delay;
    private final int period;
    private final boolean internal;

    private int tick = 0;

    public RepeatingGameTask(Runnable runnable, int delay, int period, boolean internal) {
        this.runnable = runnable;
        this.delay = delay;
        this.period = period;
        this.internal = internal;
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

    @Override
    public String toString() {
        if(internal) return "InternalGameTask (Not USER)";
        return "RepeatingGameTask{" +
                "delay=" + delay +
                ", period=" + period +
                ", cancelled=" + cancelled +
                ", running=" + running +
                '}';
    }
}
