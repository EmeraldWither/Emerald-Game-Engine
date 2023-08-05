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

    void drawCircle(int x, int y, int radius);

    void drawCircleFilled(int x, int y, int radius);

    void setColor(Color color);

    void setThickness(int thickness);

    void reset();
}
