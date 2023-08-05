package org.emeraldcraft.engine.api.gameobjects;

import java.awt.*;

public class HitBox {
    private final Rectangle r;
    private final GameObject gameObject;

    public HitBox(int width, int height, GameObject gameObject) {
        this.gameObject = gameObject;
        this.r = new Rectangle(width, height);

    }

    public int getWidth() {
        return r.width;
    }

    public int getHeight() {
        return r.height;
    }

    public boolean isIntersecting(HitBox hitbox) {
        updateLocation(hitbox);
        return r.intersects(hitbox.r);
    }

    public boolean contains(int x, int y) {
        updateLocation(x, y);
        return r.contains(x, y);
    }

    public boolean contains(HitBox hitbox) {
        updateLocation(hitbox);
        return r.contains(hitbox.r);
    }


    private void updateLocation(HitBox hitbox) {
        r.setLocation(hitbox.gameObject.getLocation().x, hitbox.gameObject.getLocation().y);
    }
    private void updateLocation(int x, int y) {
        r.setLocation(x, y);
    }

}
