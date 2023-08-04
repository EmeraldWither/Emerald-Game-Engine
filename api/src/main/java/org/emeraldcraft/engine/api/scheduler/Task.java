package org.emeraldcraft.engine.api.scheduler;

public interface Task {

    @SuppressWarnings("unused")
    void cancel();
    boolean isCancelled();
    @SuppressWarnings("unused")
    boolean isRunning();
    boolean isFinished();
}
