package org.emeraldcraft.engine.api.physics;

import lombok.Getter;
import lombok.Setter;
import org.emeraldcraft.engine.api.gameobjects.GameObject;
import org.emeraldcraft.engine.api.gameobjects.Location;
import org.emeraldcraft.engine.api.internal.GameInstance;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PhysicsObject {
    private final List<Force> forces = new ArrayList<>();
    @Setter
    private Vector2d speedVector = new Vector2d(0, 0);
    
    @Setter
    private Location location;

    @Setter
    private double mass;

    private final GameObject linkedObject;

    public PhysicsObject(GameObject linkedObject, int mass) {
        this.linkedObject = linkedObject;
        this.mass = mass;
        this.location = linkedObject.getLocation();
    }

    public Force getTotalNetForce() {
        double x = 0;
        double y = 0;
        for(Force force : forces) {
            x += force.getX();
            y += force.getY();
        }
        return new Force(x, y);
    }
    public double getXNetForce() {
        double x = 0;
        for(Force force : forces) {
            x += force.getX();
        }
        return x;
    }
    public double getYNetForce() {
        double y = 0;
        for(Force force : forces) {
            y += force.getY();
        }
        return y;
    }


    public void applyForce(Force force) {
        forces.add(force);
        double accelerationX = getXNetForce() / mass;
        double accelerationY = getYNetForce() / mass;

        speedVector.setX(accelerationX * GameInstance.getGameManager().getLastTickTime());
        speedVector.setY(accelerationY * GameInstance.getGameManager().getLastTickTime());
    }
    
    public void tickPhysics() {
        location.x += speedVector.getX();
        location.y += speedVector.getY();
    }

}
