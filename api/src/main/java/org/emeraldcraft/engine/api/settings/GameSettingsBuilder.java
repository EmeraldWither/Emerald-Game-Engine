package org.emeraldcraft.engine.api.settings;

/**
 * Helper class to make create gamesettings easier.
 */
public class GameSettingsBuilder {
    private int tickTime = 25;
    private boolean isFullScreen = true;
    private int windowSizeX = 1920 / 2;
    private int windowSizeY = 1080 / 2;

    private int gravityMeterScaling = 19;

    public GameSettingsBuilder setTickTime(int tickTime) {
        this.tickTime = tickTime;
        return this;
    }

    public GameSettingsBuilder setIsFullScreen(boolean isFullScreen) {
        this.isFullScreen = isFullScreen;
        return this;
    }

    public GameSettingsBuilder setWindowSizeX(int windowSizeX) {
        this.windowSizeX = windowSizeX;
        return this;
    }

    public GameSettingsBuilder setWindowSizeY(int windowSizeY) {
        this.windowSizeY = windowSizeY;
        return this;
    }

    public void setGravityMeterScaling(int gravityMeterScaling) {
        this.gravityMeterScaling = gravityMeterScaling;
    }

    public GameSettings getSettings() {
        return new GameSettings(tickTime, isFullScreen, windowSizeX, windowSizeY, gravityMeterScaling);
    }
}