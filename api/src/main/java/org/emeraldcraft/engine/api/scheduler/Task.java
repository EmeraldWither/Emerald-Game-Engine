package org.emeraldcraft.engine.api.scheduler;

/**
 * Represents a Task which has been scheduled by the TaskScheduler.
 */
public interface Task {
    @SuppressWarnings("unused")
    void cancel();
    boolean isCancelled();
    @SuppressWarnings("unused")
    boolean isRunning();
    boolean isFinished();
}
