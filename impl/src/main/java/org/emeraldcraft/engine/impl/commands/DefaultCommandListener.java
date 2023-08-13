package org.emeraldcraft.engine.impl.commands;

import org.emeraldcraft.engine.api.EmeraldGameEngine;
import org.emeraldcraft.engine.api.commands.CommandListener;
import org.emeraldcraft.engine.api.commands.CommandLogger;
import org.emeraldcraft.engine.api.gameobjects.GameObject;
import org.emeraldcraft.engine.api.settings.DebugSettings;

public class DefaultCommandListener implements CommandListener {
    @Override
    public void onCommand(String command, String[] args, CommandLogger logger) {
        //hitboxes command
        if (command.equalsIgnoreCase("hitboxes")) {
            //check to if it for all or just a single person
            if (args.length > 0 && (args[0].equalsIgnoreCase("hide") || args[0].equalsIgnoreCase("show"))) {
                DebugSettings.SHOW_HITBOXES = args[0].equalsIgnoreCase("show");
                logger.log("OK");
                return;
            }
            logger.log("Invalid command. Usage: \"hitboxes [show/hide]");
            return;
        }
        //list command
        if (command.equalsIgnoreCase("list")) {
            //gameobjects
            if (args.length > 0 && args[0].equalsIgnoreCase("gameobjects")) {
                for (GameObject gameObject : EmeraldGameEngine.getGameObjects()) {
                    logger.log(gameObject.toString());
                }
                logger.log("OK");
            }
            //tasks
            else if (args.length > 0 && args[0].equalsIgnoreCase("tasks")) {
                EmeraldGameEngine.getTaskScheduler().getTasks().forEach(task -> logger.log(task.toString()));
                logger.log("OK");
            }
            else {
                logger.log("Command not found. Type help for a list of default commands.");
            }

        }
        //help command
        if (command.equalsIgnoreCase("help")) {
            logger.log("hitboxes [show/hide] - Shows or hides hitboxes");
            logger.log("list gameobjects - Lists all gameobjects");
            logger.log("list tasks - Lists all tasks scheduled in the TaskScheduler");
            logger.log("OK");
        }


    }
}
