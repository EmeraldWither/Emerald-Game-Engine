package org.emeraldcraft.engine.api.commands;

public interface CommandListener {
    void onCommand(String command, String[] args, CommandLogger logger);
}
