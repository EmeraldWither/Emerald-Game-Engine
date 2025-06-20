package org.emeraldcraft.engine.api.physics;

import lombok.Getter;

@Getter
public class Force {
    private final double x;
    private final double y;

    public Force(double x, double y) {
        this.x = x;
        this.y = y;
    }

}
