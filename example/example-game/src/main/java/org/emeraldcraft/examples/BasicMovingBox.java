package org.emeraldcraft.examples;

import org.emeraldcraft.engine.api.gameobjects.GameObject;
import org.emeraldcraft.engine.api.render.Renderer;

import java.awt.*;

public class BasicMovingBox extends GameObject {
    public BasicMovingBox() {
        super("Basic Moving Box", new Rectangle(50, 100), 1);

    }

    @Override
    public boolean shouldRemove() {
        //lets remove this box when its x value is past 500
        return getLocation().x > 500;
    }

    @Override
    public void onDraw(Renderer renderer) {
        //Draw a red rectangle
        renderer.setColor(Color.RED);
        renderer.drawRectFilled(getLocation().x, getLocation().y, getHitBox().getWidth(), getHitBox().getWidth());

        //and draw a circle on top of it
        renderer.setColor(Color.GREEN);
        renderer.drawCircleFilled(getLocation().x + (25 - 25/2), getLocation().y - 25, 25);
    }

    @Override
    public void tick() {
        getLocation().x++;
        getLocation().y = 50;
    }
}
