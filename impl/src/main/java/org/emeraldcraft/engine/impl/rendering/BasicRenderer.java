package org.emeraldcraft.engine.impl.rendering;

import org.emeraldcraft.engine.api.render.ImageAsset;
import org.emeraldcraft.engine.api.render.Renderer;

import java.awt.*;

public class BasicRenderer implements Renderer {

    private Graphics2D g2d;

    public BasicRenderer(Graphics2D g2d) {
        this.g2d = g2d;
    }

    public void updateGraphicsObject(Graphics2D g2d) {
        this.g2d = g2d;
    }


    @Override
    public void drawRect(int x, int y, int width, int height) {
        g2d.drawRect(x, y, width, height);
    }

    @Override
    public void drawRectFilled(int x, int y, int width, int height) {
        g2d.fillRect(x, y, width, height);
    }

    @Override
    public void drawCircle(int x, int y, int radius) {
        g2d.drawOval(x, y, radius * 2, radius * 2);
    }

    @Override
    public void drawCircleFilled(int x, int y, int radius) {
        g2d.fillOval(x, y, radius * 2 , radius * 2);
    }

    @Override
    public void setColor(Color color) {
        g2d.setColor(color);
    }

    @Override
    public void setThickness(int thickness) {
        g2d.setStroke(new BasicStroke(thickness));
    }

    @Override
    public void translate(int x, int y) {
        g2d.translate(x, y);
    }

    @Override
    public void rotateDegrees(double angle) {
        g2d.rotate(Math.toRadians(angle));
    }

    @Override
    public void drawString(String text, int x, int y) {
        g2d.drawString(text, x, y);
    }

    @Override
    public void drawImage(ImageAsset imageAsset, int x, int y) {
        g2d.drawImage(imageAsset.getImage(), x, y, null);
    }

    @Override
    public void reset() {
        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(2));
    }


}
