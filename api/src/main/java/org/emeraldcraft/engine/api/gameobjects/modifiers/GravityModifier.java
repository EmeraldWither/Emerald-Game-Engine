package org.emeraldcraft.engine.api.gameobjects.modifiers;

import org.emeraldcraft.engine.api.gameobjects.GameObject;
import org.emeraldcraft.engine.api.internal.GameInstance;
import org.emeraldcraft.engine.api.physics.Force;

public class GravityModifier implements ObjectModifier{

    @Override
    public void onTick(GameObject gameObject) {
        System.out.println("ticked");
        double mass = gameObject.getPhysics().getMass();
        double gravityModifier = GameInstance.getGame().getSettings().getGravityMeterScaling();
        gameObject.getPhysics().applyForce(new Force(0, -mass * gravityModifier));
    }
}
