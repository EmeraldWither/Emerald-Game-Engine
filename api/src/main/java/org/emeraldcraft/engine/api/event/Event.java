package org.emeraldcraft.engine.api.event;

import lombok.Getter;

@Getter
public abstract class Event {
    private final String name;

    public Event(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                '}';
    }


}
