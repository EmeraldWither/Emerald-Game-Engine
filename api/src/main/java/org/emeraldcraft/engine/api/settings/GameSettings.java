package org.emeraldcraft.engine.api.settings;

public class GameSettings {

    private final int tickTime;
    private final boolean isFullScreen;
    private final int windowSizeX;
    private final int windowSizeY;

    public GameSettings(int tickTime, boolean isFullScreen, int windowSizeX, int windowSizeY) {
        this.tickTime = tickTime;
        this.isFullScreen = isFullScreen;
        this.windowSizeX = windowSizeX;
        this.windowSizeY = windowSizeY;
    }

    public int getTickTime() {
        return tickTime;
    }

    public boolean isFullScreen() {
        return isFullScreen;
    }

    public int getWindowSizeX() {
        return windowSizeX;
    }

    public int getWindowSizeY() {
        return windowSizeY;
    }

    @Override
    public String toString() {
        return "GameSettings{" +
                "tickTime=" + tickTime +
                ", isFullScreen=" + isFullScreen +
                ", windowSizeX=" + windowSizeX +
                ", windowSizeY=" + windowSizeY +
                '}';
    }
}
