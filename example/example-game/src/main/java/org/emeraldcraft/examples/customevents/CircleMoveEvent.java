package org.emeraldcraft.examples.customevents;

import org.emeraldcraft.engine.api.event.Event;
import org.emeraldcraft.examples.ControllableCircle;

public class CircleMoveEvent extends Event {
    private final ControllableCircle circle;
    public CircleMoveEvent(ControllableCircle circle) {
        super("Circle Move Event");
        this.circle = circle;
    }

    public ControllableCircle getCircle() {
        return circle;
    }
}
