package org.emeraldcraft.engine.api.gameobjects;

import lombok.Getter;
import org.emeraldcraft.engine.api.HitBox;

public class Location {
    @Getter
    private final HitBox hitbox;
    public int x = 0;
    public int y = 0;

    public double rotationRadians = 0;


    public Location(HitBox hitbox) {
        this.hitbox = hitbox;
    }

    public double getDistance(Location loc){
        return Math.sqrt(Math.pow(loc.x - this.x, 2) + Math.pow(loc.y - this.y, 2));
    }
    public double rotationToDegrees(){
        return Math.toDegrees(rotationRadians);
    }
}
