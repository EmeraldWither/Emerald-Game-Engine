package org.emeraldcraft.engine.api.gameobjects.physics;

import lombok.SneakyThrows;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Vector2;
import org.dyn4j.world.World;
import org.emeraldcraft.engine.api.gameobjects.GameObject;
import org.emeraldcraft.engine.api.internal.GameInstance;

import java.awt.*;

public abstract class AdvancedPhysicsGameObject extends GameObject {
    protected final Body body;
    private final int gravityScaling = GameInstance.getGame().getSettings().getGravityMeterScaling();
    private Image image;
    private int deltaX;
    private int deltaY;


    /**
     * @param name           The name of the gameobject
     * @param hitbox         A rectangle specifying the hitbox and point
     * @param renderPriority The lower the number the closer it to the front. Must be at least 1
     */
    public AdvancedPhysicsGameObject(String name, Rectangle hitbox, int renderPriority) {
        super(name, hitbox, renderPriority);
        World<Body> world = GameInstance.getGameManager().getPhysicsWorld();

        // Create some objects
//        org.dyn4j.geometry.Rectangle floor = Geometry.createRectangle(10.0, 1.0);
//        floor.translate(0.0, -15.0);
//        Body floorBody = new Body();
//        floorBody.addFixture(floor);
//        floorBody.setMass(MassType.INFINITE);

        org.dyn4j.geometry.Rectangle box = Geometry.createRectangle(10, 10);
        this.body = new Body();
        body.setMass(MassType.NORMAL);
        body.addFixture(box);
        //world.addBody(floorBody);
        world.addBody(body);
        body.setEnabled(true);
        body.setGravityScale(15);
        body.applyForce(new Vector2(5, 5));
    }

    public void tickPhysics() {
        getLocation().x += body.getChangeInPosition().x * gravityScaling;
        getLocation().y -= body.getChangeInPosition().y * gravityScaling;
        getLocation().rotationRadians = body.getChangeInOrientation();
    }

    @SneakyThrows
    @Override
    public void render(Graphics g) {
        if (this.image == null && imageAsset != null) {
            this.image = imageAsset.getImage();
        }
        if (this.image == null) return;

        Vector2 position = body.getWorldPoint(((org.dyn4j.geometry.Polygon) body.getFixture(0).getShape()).getVertices()[0]);
        double x = position.x;
        double y = position.y;

        g.drawString("X: " + x + " Y: " + y, 30, 70);

        // Render the body with rotation
        g.setColor(Color.BLUE);
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(x, y);
        //g2d.rotate(-angle);
        g2d.fillRect(0, 100, 100, 100);
        g2d.dispose();
    }
}
