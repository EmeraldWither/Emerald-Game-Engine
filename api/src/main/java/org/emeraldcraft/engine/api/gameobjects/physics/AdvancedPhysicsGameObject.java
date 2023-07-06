package org.emeraldcraft.engine.api.gameobjects.physics;

import lombok.SneakyThrows;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;
import org.dyn4j.world.World;
import org.emeraldcraft.engine.api.gameobjects.GameObject;
import org.emeraldcraft.engine.api.internal.GameInstance;

import java.awt.*;

public abstract class AdvancedPhysicsGameObject extends GameObject {
    private final Body body;
    private Image image;

    /**
     * @param name           The name of the gameobject
     * @param hitbox         A rectangle specifying the hitbox and point
     * @param renderPriority The lower the number the closer it to the front. Must be at least 1
     */
    public AdvancedPhysicsGameObject(String name, Rectangle hitbox, int renderPriority) {
        super(name, hitbox, renderPriority);
        World<Body> world = GameInstance.getGameManager().getPhysicsWorld();
        this.body = new Body();
        org.dyn4j.geometry.Rectangle rec = Geometry.createRectangle(hitbox.width, hitbox.height);
        this.body.addFixture(rec);
        this.body.setEnabled(true);
        this.body.rotate(Math.toRadians(45));
        this.body.setMass(MassType.NORMAL);


        Rectangle floorRect = new Rectangle(15, 1);
        Body floor = new Body();
        floor.addFixture(Geometry.createRectangle(floorRect.width, floorRect.height));
        floor.setMass(MassType.INFINITE);
        // move the floor down a bit
        floor.translate(0.0, -4.0);

        world.addBody(floor);
        world.addBody(body);
    }
    public void tickPhysics(){
        getLocation().x += body.getChangeInPosition().x;
        getLocation().y += body.getChangeInPosition().y;
        getLocation().rotationRadians += body.getChangeInOrientation();
    }

    @SneakyThrows
    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        if (this.image == null && imageAsset != null) {
            this.image = imageAsset.getImage();
        }
        if(this.image == null) return;
        g2d.rotate(getLocation().rotationRadians);

        g2d.drawImage(image, getLocation().x, getLocation().y, null);
        g2d.drawString("X: " + getLocation().x + " Y: " + getLocation().y + "Rotation Radians: " + getLocation().rotationRadians, 30, 30);
        g2d.drawString("X Change in Pos: " + body.getChangeInPosition().x + " Y Change in Pos: " + body.getChangeInPosition().y + "Rotation Change in Radians: " + body.getChangeInOrientation(), 30, 50);
    }
}
