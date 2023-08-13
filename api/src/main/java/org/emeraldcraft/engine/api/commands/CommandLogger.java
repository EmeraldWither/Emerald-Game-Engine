package org.emeraldcraft.engine.api.commands;

import org.emeraldcraft.engine.api.utils.Logger;

public class CommandLogger {
    private final String command;

    public CommandLogger(String command){
        this.command = command;
    }
    public void log(String msg){
        Logger.command(command, msg);
    }
}
