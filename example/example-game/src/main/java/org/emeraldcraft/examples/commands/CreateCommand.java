package org.emeraldcraft.examples.commands;

import org.emeraldcraft.engine.api.commands.CommandListener;
import org.emeraldcraft.engine.api.commands.CommandLogger;
import org.emeraldcraft.examples.BasicMovingBox;
import org.emeraldcraft.examples.ControllableCircle;

public class CreateCommand implements CommandListener {
    @Override
    public void onCommand(String command, String[] args, CommandLogger logger) {
        if ("movingbox".equals(args[0])) {
            new BasicMovingBox();
            logger.log("OK. Created a new moving box!");
        }
        if("circle".equals(args[0])) {
            new ControllableCircle();
            logger.log("OK. Created a new controllable circle!");
        }

    }
}
