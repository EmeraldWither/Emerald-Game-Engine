package org.emeraldcraft.examples.game;


import org.emeraldcraft.engine.api.gameobjects.physics.AdvancedPhysicsGameObject;
import org.emeraldcraft.engine.api.render.ImageAsset;
import org.emeraldcraft.engine.api.render.Renderer;

import java.awt.*;

public class Thing extends AdvancedPhysicsGameObject {
    public Thing() {
        super("Hello There", new Rectangle(2, 2), 1);
        setImageAsset(new ImageAsset("box.png"));
    }

    @Override
    public boolean shouldRemove() {
        return false;
    }

    @Override
    public void onDraw(Renderer renderer) {

    }

    @Override
    public void tick() {
        super.tickPhysics();
    }
}
