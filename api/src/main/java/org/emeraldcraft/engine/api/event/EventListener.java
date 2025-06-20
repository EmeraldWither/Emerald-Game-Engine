package org.emeraldcraft.engine.api.event;

/**
 * Classes implement this interface to build custom events.
 */
public interface EventListener {
    void onEvent(Event event);
}
