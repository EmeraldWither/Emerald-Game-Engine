package org.emeraldcraft.engine.impl.commands.handler;

import org.emeraldcraft.engine.api.EmeraldGameEngine;
import org.emeraldcraft.engine.impl.GameEngine;

import java.util.Scanner;

public class EmeraldCommandScanner extends Thread {
    public EmeraldCommandScanner() {
    }

    @Override
    public void run() {
        //noinspection InfiniteLoopStatement
        Scanner in = new Scanner(System.in);
        if(true) return;
        while (true) {
            //TODO FIX THIS WITH ACTUAL READING!
            String command = "";

        }
    }
}
