package org.emeraldcraft.engine.impl;

import org.emeraldcraft.engine.api.internal.InternalEmeraldLogger;
import org.emeraldcraft.engine.impl.commands.gui.CommandGUIManager;

public class EmeraldLogger implements InternalEmeraldLogger {
    private final CommandGUIManager guiManager;

    public EmeraldLogger(CommandGUIManager commandGUIManager) {
        this.guiManager = commandGUIManager;
    }

    @Override
    public void log(String s) {
        System.out.println(s);
        guiManager.log(s);
    }
}
