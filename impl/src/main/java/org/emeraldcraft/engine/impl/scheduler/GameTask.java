package org.emeraldcraft.engine.impl.scheduler;

import org.emeraldcraft.engine.api.scheduler.Task;

public abstract class GameTask implements Task {
    protected boolean cancelled = false;
    protected boolean running = false;

    public abstract void tick();

    @Override
    public void cancel() {
        cancelled = true;
        running = false;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

}
