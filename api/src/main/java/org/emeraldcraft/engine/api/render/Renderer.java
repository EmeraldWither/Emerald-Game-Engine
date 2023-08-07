package org.emeraldcraft.engine.api.render;

import java.awt.*;

/**
 * The renderer which will do the drawing to the screen.
 */
public interface Renderer {

    /**
     * Will draw a rectangle which only has an outline.
     * You can change the width of the outline by calling the {@link Renderer#setThickness}
     *
     * @param x X location
     * @param y y location
     * @param width width of the rectangle
     * @param height height of the rectangle
     */
    void drawRect(int x, int y, int width, int height);


    /**
     * Will draw a filled rectangle.

     *
     * @param x X location
     * @param y y location
     * @param width width
     * @param height height
     */
    void drawRectFilled(int x, int y, int width, int height);

    /**
     *  Will draw a circle which only has an outline.
     *
     * @param x X location
     * @param y y location
     * @param radius radius of the circle
     */
    void drawCircle(int x, int y, int radius);

    /**
     * Will draw a filled circle.
     *
     * @param x X location
     * @param y y location
     * @param radius radius of the circle
     */
    void drawCircleFilled(int x, int y, int radius);

    /**
     * @param color the color to set the renderer to
     */
    void setColor(Color color);

    /**
     * @param thickness the thickness of the outline of the shape in pixels
     */
    void setThickness(int thickness);

    void translate(int x, int y);

    void rotateDegrees(double angle);

    void drawString(String text, int x, int y);

    void drawImage(ImageAsset imageAsset, int x, int y);

    /**
     * Will reset the renderer to the default settings.
     */
    void reset();
}
