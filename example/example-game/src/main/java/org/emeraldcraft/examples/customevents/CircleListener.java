package org.emeraldcraft.examples.customevents;

import org.emeraldcraft.engine.api.event.Event;
import org.emeraldcraft.engine.api.event.EventHandler;
import org.emeraldcraft.engine.api.event.EventListener;

public class CircleListener implements EventListener {
    @Override
    public void onEvent(Event event) {

    }

    @EventHandler
    public void onCircleMoveEvent(CircleMoveEvent event) {
//        Logger.log("Circle is moving!");
    }
}
