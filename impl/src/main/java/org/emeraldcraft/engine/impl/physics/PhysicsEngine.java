package org.emeraldcraft.engine.impl.physics;

import lombok.Getter;
import org.dyn4j.dynamics.Body;
import org.dyn4j.world.World;
import org.emeraldcraft.engine.api.utils.Logger;

public class PhysicsEngine {
    private Long startTime;
    @Getter
    private World<Body> world;
    public void setupEngine(){
        world = new World<>();
        startTime = System.currentTimeMillis();
    }
    public void tick(){
        long currentTime = System.currentTimeMillis();
        double deltaTime = currentTime - startTime;
        //convert to seconds
        deltaTime /= 1000.0;
        if(!world.update(deltaTime)){
            Logger.warn("Physics engine failed to update. " + deltaTime + " seconds have passed");
            return;
        }
        Logger.log("Physics engine updated successfully. " + deltaTime + " seconds have passed");
    }
}
