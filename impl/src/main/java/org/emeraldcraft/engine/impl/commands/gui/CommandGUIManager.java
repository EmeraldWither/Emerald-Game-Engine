package org.emeraldcraft.engine.impl.commands.gui;

import org.emeraldcraft.engine.api.utils.Logger;

public class CommandGUIManager {
    private final CommandGUIFrame jFrame = new CommandGUIFrame();

    public void endGUI() {
        jFrame.dispose();
        Logger.log("Ending command GUI.");
    }
    public void showGUI(){
        jFrame.setVisible(true);
        jFrame.requestFocus();
        Logger.log("Showing command GUI.");
    }
    public void hideGUI() {
        jFrame.setVisible(false);
        Logger.log("Hiding command GUI.");
    }

    public void toggleGUI() {
        if(jFrame.isVisible()){
            hideGUI();
        } else {
            showGUI();
        }
    }
}
