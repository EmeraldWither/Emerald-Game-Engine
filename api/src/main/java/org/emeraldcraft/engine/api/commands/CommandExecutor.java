package org.emeraldcraft.engine.api.commands;

public interface CommandExecutor {
    void registerCommand(String command, CommandListener listener);

    void unregisterCommand(String command);

    void unregisterListener(CommandListener listener);
}
