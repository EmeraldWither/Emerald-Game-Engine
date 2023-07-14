package org.emeraldcraft.engine.api.settings;

public class GameSettings {

    private final int tickTime;
    private final boolean isFullScreen;
    private final int windowSizeX;
    private final int windowSizeY;
    private final int gravityMeterScaling;

    public GameSettings(int tickTime, boolean isFullScreen, int windowSizeX, int windowSizeY, int gravityMeterScaling) {
        this.tickTime = tickTime;
        this.isFullScreen = isFullScreen;
        this.windowSizeX = windowSizeX;
        this.windowSizeY = windowSizeY;
        this.gravityMeterScaling = gravityMeterScaling;
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

    public int getGravityMeterScaling() {
        return gravityMeterScaling;
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
