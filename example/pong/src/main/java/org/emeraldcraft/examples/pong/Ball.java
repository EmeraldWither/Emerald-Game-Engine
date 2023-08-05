package org.emeraldcraft.examples.pong;

import org.emeraldcraft.engine.api.EmeraldGameEngine;
import org.emeraldcraft.engine.api.gameobjects.GameObject;
import org.emeraldcraft.engine.api.render.Renderer;

import java.awt.*;
import java.util.List;

public class Ball extends GameObject {
    private int xDirection = 10;
    private int yDirection = 10;

    private boolean hitLeft = false;
    private boolean hitRight = false;

    public Ball() {
        super("Ball", new Rectangle(50, 50), 1);
        reset();

    }
    public void reset(){
        this.getLocation().x = (int) (EmeraldGameEngine.getScreenSize().getWidth() / 2);
        this.getLocation().y = (int) (EmeraldGameEngine.getScreenSize().getHeight() / 2);
        xDirection = 10;
        yDirection = 10;
    }

    @Override
    public boolean shouldRemove() {
        return false;
    }

    @Override
    public void onDraw(Renderer renderer) {
        renderer.drawCircleFilled(getLocation().x, getLocation().y, 25);
    }

    @Override
    public void tick() {
        List<GameObject> paddles = EmeraldGameEngine.getGameObjectsByType(Paddle.class);
        boolean hitAnything = false;
        for (GameObject paddle : paddles) {
            if (paddle.getHitBox().isIntersecting(this.getHitBox())) {
                hitAnything = true;
                Paddle.PaddleSide side = ((Paddle) paddle).getSide();
                if(side == Paddle.PaddleSide.LEFT){
                    if(hitLeft) continue;
                }
                if(side == Paddle.PaddleSide.RIGHT){
                    if(hitRight) continue;
                }

                xDirection *= -1;
                if(xDirection > 0 ) xDirection += 5;
                else xDirection -=5;
                if(side == Paddle.PaddleSide.LEFT){
                   hitLeft = true;
                }
                if(side == Paddle.PaddleSide.RIGHT){
                    hitRight = true;
                }

                break;
            }
        }
        if(!hitAnything){
            hitLeft = false;
            hitRight = false;
        }
        //check for celing
        if (getLocation().y <= 0 || getLocation().y >= EmeraldGameEngine.getScreenSize().height - 50) yDirection *= -1;

        this.getLocation().x += xDirection;
        this.getLocation().y += yDirection;

        if(isOutOfBounds()) reset();


    }
    public boolean isOutOfBounds(){
        if(getLocation().x >= EmeraldGameEngine.getScreenSize().width) return true;
        return getLocation().x <= 0;
    }
}
