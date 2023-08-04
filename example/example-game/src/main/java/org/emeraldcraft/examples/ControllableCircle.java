package org.emeraldcraft.examples;

import org.emeraldcraft.engine.api.EmeraldGameEngine;
import org.emeraldcraft.engine.api.gameobjects.GameObject;
import org.emeraldcraft.engine.api.input.Controllable;
import org.emeraldcraft.engine.api.input.KeyCode;
import org.emeraldcraft.engine.api.render.Renderer;
import org.emeraldcraft.engine.api.scheduler.Task;
import org.emeraldcraft.engine.api.utils.Logger;

import java.awt.*;
import java.util.List;


public class ControllableCircle extends GameObject implements Controllable {
    private final Task task;

    public ControllableCircle() {
        super("Controllable Circle", new Rectangle(50, 50), 1);
        task = EmeraldGameEngine.getTaskScheduler().scheduleRepeatingTask(
                () -> Logger.log("Press \"C\" on your keyboard to cancel me!"),
                40,
                40
        );
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
    public void tick() {}

    @Override
    public void onKeyboardInput(List<KeyCode> keys) {
        if (keys.contains(KeyCode.W))
            getLocation().y -= 10;
        if (keys.contains(KeyCode.S))
            getLocation().y += 10;
        if (keys.contains(KeyCode.A))
            getLocation().x -= 10;
        if (keys.contains(KeyCode.D))
            getLocation().x += 10;
        if(keys.contains(KeyCode.C))
            task.cancel();
    }
}
