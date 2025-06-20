package org.emeraldcraft.examples;

import org.emeraldcraft.engine.api.gameobjects.GameObject;
import org.emeraldcraft.engine.api.gameobjects.modifiers.GravityModifier;
import org.emeraldcraft.engine.api.render.Renderer;

import java.awt.*;

public class GravityBox extends GameObject {
    public GravityBox() {
        super("Gravity Box", new Rectangle(20, 30), 1, 1);
        addModifier(new GravityModifier());
    }

    @Override
    public boolean shouldRemove() {
        return false;
    }

    @Override
    public void onDraw(Renderer renderer) {
        renderer.setColor(Color.BLUE);
        renderer.drawRectFilled((int) getLocation().x, (int) getLocation().y, getHitBox().getWidth(), getHitBox().getWidth());
    }

    @Override
    public void tick() {
        getPhysics().tickPhysics();
    }
}
