package org.emeraldcraft.engine.impl.commands.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CommandGUIKeyListener implements KeyListener {
    private final CommandGUIManager guiManager;

    public CommandGUIKeyListener(CommandGUIManager guiManager) {
        this.guiManager = guiManager;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == '/'){
            guiManager.toggleGUI();
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
