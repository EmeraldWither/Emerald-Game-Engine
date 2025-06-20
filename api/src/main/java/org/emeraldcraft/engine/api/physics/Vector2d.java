package org.emeraldcraft.engine.api.physics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vector2d {
    private double x;
    private double y;

    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
