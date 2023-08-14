package org.emeraldcraft.engine.impl.commands.handler;

import org.emeraldcraft.engine.api.commands.CommandExecutor;
import org.emeraldcraft.engine.api.commands.CommandListener;
import org.emeraldcraft.engine.api.commands.CommandLogger;
import org.emeraldcraft.engine.api.utils.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmeraldCommandExecutor implements CommandExecutor {

    private final HashMap<String, List<CommandListener>> listeners = new HashMap<>();
    private final EmeraldCommandScanner emeraldCommandScanner = new EmeraldCommandScanner();

    @Override
    public void registerCommand(String command, CommandListener listener) {
        //check to see if a command is registered
        if (listeners.containsKey(command)) {
            //add the listener to the list of listeners
            listeners.get(command).add(listener);
        } else {
            //create it ourselves
            ArrayList<CommandListener> listenersList = new ArrayList<>();
            listenersList.add(listener);
            listeners.put(command, listenersList);
        }
    }

    @Override
    public void unregisterCommand(String command) {
        listeners.remove(command);
    }

    @Override
    public void unregisterListener(CommandListener listener) {
        for (List<CommandListener> commandListeners : listeners.values()) {
            commandListeners.remove(listener);
        }
    }

    public void onCommand(String command, String[] args) {
        boolean ran = false;
        String fullCommand = command + " " + String.join(" ", args);
        if (listeners.containsKey(command)) {
            for (CommandListener listener : listeners.get(command)) {
                listener.onCommand(command, args, new CommandLogger(fullCommand));
                ran = true;
            }
        }
        if(!ran){
            Logger.command(fullCommand, "Command not found. Run help for a list of default commands.");
        }
    }
    public void start(){
        emeraldCommandScanner.start();
    }
}
