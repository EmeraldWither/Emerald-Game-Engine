package org.emeraldcraft.engine.impl.commands.gui;

import org.emeraldcraft.engine.api.EmeraldGameEngine;
import org.emeraldcraft.engine.impl.GameEngine;
import org.emeraldcraft.engine.impl.commands.handler.EmeraldCommandExecutor;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CommandGUIFrame extends JFrame {
    private JTextArea consoleText;
    public CommandGUIFrame() {
        super("Emerald Engine Command GUI");
        constructGUI();
    }
    private void constructGUI() {
        setSize(500, 500);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        mainPanel.add(getLogWindow());

        JTextField commandField = getCommandField();
        mainPanel.add(commandField, BorderLayout.SOUTH);

        this.add(mainPanel);
    }

    private JScrollPane getLogWindow() {
        consoleText = new JTextArea();
        //consoleText.setOpaque(false);

        JScrollPane scrollPane = new JScrollPane(consoleText);
        consoleText.setEditable(false);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBackground(Color.white);
        consoleText.setFont(new Font("Consolas", Font.PLAIN, 12));
        return scrollPane;
    }
    @NotNull
    private JTextField getCommandField(){
        JTextField commandField = new JTextField();
        commandField.setFont(new Font("Consolas", Font.PLAIN, 12));
        commandField.setToolTipText("Run CLI commands to games using the Emerald Command API.");
        commandField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == KeyEvent.VK_ENTER){
                    String command = commandField.getText();
                    commandField.setText("");
                    //process the command
                    String baseCommand = command.split(" ")[0];
                    String[] args;
                    if (command.split(" ").length == 1) args = new String[0];
                    else args = command.substring(command.indexOf(" ") + 1).split(" ");
                    GameEngine.getGameManager().getTaskExecutor().markNextTaskAsInternal();
                    GameEngine.getGameManager().getTaskExecutor().scheduleDelayedTask(() -> ((EmeraldCommandExecutor) EmeraldGameEngine.getCommandsAPI())
                                    .onCommand(baseCommand, args)
                            , 0);

                }
            }
            @Override public void keyPressed(KeyEvent e) {}
            @Override public void keyReleased(KeyEvent e) {}
        });
        return commandField;
    }
    public void appendLogs(String text) {
        consoleText.append(text + "\n ");
    }
}
