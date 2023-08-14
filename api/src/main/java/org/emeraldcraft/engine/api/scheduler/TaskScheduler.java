package org.emeraldcraft.engine.api.scheduler;

import org.jetbrains.annotations.Range;

import java.util.List;

/**
 * Allows code to be run at different times.
 * Based off of the Bukkit API.
 */
public interface TaskScheduler {
    /**
     * Will run the code after a "delay" number of ticks.
     *
     * @param runnable Code to run
     * @param delay number of ticks
     * @return The task representing this
     */
    @SuppressWarnings("unused")
    Task scheduleDelayedTask(Runnable runnable, @Range(from = 0, to = Integer.MAX_VALUE) int delay);

    /**
     * Will run code after a "delay" number of ticks, and then repeat it every "period" ticks
     *
     * @param runnable Code to run
     * @param delay number of ticks to wait before running
     * @param period number of ticks to wait between each run
     * @return The task representing this
     */
    @SuppressWarnings("unused")
    Task scheduleRepeatingTask(Runnable runnable, @Range(from = 0, to = Integer.MAX_VALUE) int delay, @Range(from = 1, to = Integer.MAX_VALUE) int period);

    List<Task> getTasks();
}
