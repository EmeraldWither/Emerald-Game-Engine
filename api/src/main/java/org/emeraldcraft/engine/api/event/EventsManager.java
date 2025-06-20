package org.emeraldcraft.engine.api.event;

public interface EventsManager {
    void registerListener(EventListener handler);
    void unregisterListener(EventListener handler);
    void dispatchEvent(Event event);
}
