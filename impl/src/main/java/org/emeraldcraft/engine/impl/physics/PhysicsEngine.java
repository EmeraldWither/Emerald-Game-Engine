package org.emeraldcraft.engine.impl.physics;

import lombok.Getter;
import org.dyn4j.dynamics.Body;
import org.dyn4j.world.World;

public class PhysicsEngine {
    private Long startTime;
    @Getter
    private World<Body> world;
    public void setupEngine(){
        world = new World<>();
        world.setBounds(null);
        startTime = System.currentTimeMillis();
    }
    public void tick(){
        long currentTime = System.currentTimeMillis();
        double deltaTime = currentTime - startTime;
        //convert to seconds
        deltaTime /= 1000.0;
        world.updatev(deltaTime);
    }
}
