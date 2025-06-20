package org.emeraldcraft.engine.api.event.included;

import lombok.Getter;
import org.emeraldcraft.engine.api.event.Event;
import org.emeraldcraft.engine.api.gameobjects.GameObject;

public class GameObjectTickEvent extends Event {
    @Getter
    private final GameObject gameObject;

    public GameObjectTickEvent(GameObject gameObject) {
        super("Game Object Tick Event");
        this.gameObject = gameObject;
    }
}
