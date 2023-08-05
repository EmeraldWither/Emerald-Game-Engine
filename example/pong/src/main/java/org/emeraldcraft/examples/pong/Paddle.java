package org.emeraldcraft.examples.pong;

import org.emeraldcraft.engine.api.EmeraldGameEngine;
import org.emeraldcraft.engine.api.gameobjects.GameObject;
import org.emeraldcraft.engine.api.input.Controllable;
import org.emeraldcraft.engine.api.input.KeyCode;
import org.emeraldcraft.engine.api.render.Renderer;

import java.awt.*;
import java.util.List;

public class Paddle extends GameObject implements Controllable {
    private final PaddleSide side;

    public Paddle(PaddleSide side){
        super(side.name() + " Paddle", new Rectangle(50, 100), 1);
        this.side = side;
    }
    @Override
    public boolean shouldRemove() {
        return false;
    }

    @Override
    public void onDraw(Renderer renderer) {
        renderer.drawRectFilled(getLocation().x, getLocation().y, 50, 100);
    }

    @Override
    public void tick() {
        if(side == PaddleSide.LEFT) getLocation().x = 50;
        else getLocation().x = EmeraldGameEngine.getScreenSize().width - 100;
    }

    @Override
    public void onKeyboardInput(List<KeyCode> keys) {
        if(keys.contains(KeyCode.W) && side == PaddleSide.LEFT)
            moveUp();
        if(keys.contains(KeyCode.S) && side == PaddleSide.LEFT)
            moveDown();
        if(keys.contains(KeyCode.I) && side == PaddleSide.RIGHT)
            moveUp();
        if(keys.contains(KeyCode.K) && side == PaddleSide.RIGHT)
            moveDown();
    }
    private void moveUp(){
        if(getLocation().y <= 0) return;
        getLocation().y -= 27;
    }
    private void moveDown(){
        if(getLocation().y >= EmeraldGameEngine.getScreenSize().height - 100) getLocation().y = EmeraldGameEngine.getScreenSize().height - 100;
        else getLocation().y += 27;
    }

    public PaddleSide getSide() {
        return side;
    }

    public enum PaddleSide {
        LEFT,
        RIGHT
    }

}
