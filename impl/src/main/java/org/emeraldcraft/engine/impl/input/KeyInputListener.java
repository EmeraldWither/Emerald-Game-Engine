package org.emeraldcraft.engine.impl.input;

import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

//https://github.com/TimothyWrightSoftware/Fundamental-2D-Game-Programming-With-Java/blob/master/CH02/src/javagames/util/KeyboardInput.java
public class KeyInputListener implements KeyListener {

    private final boolean[] keys;
    private final int[] polled;

    public KeyInputListener() {
        keys = new boolean[ 256 ];
        polled = new int[ 256 ];
    }

    public boolean keyDown( int keyCode ) {
        return polled[ keyCode ] > 0;
    }

    public boolean keyDownOnce( int keyCode ) {
        return polled[ keyCode ] == 1;
    }

    public List<KeyCode> getCurrentKeys() {
        List<KeyCode> keys = new ArrayList<>();
        for (int i = 0; i < 256; i++)
            if (keyDown(i)) keys.add(fromInt(i));
        return keys;
    }
    public KeyCode fromInt(int key){
        Field[] fields = java.awt.event.KeyEvent.class.getDeclaredFields();
        for (Field f : fields) {
            if (Modifier.isStatic(f.getModifiers())) {
                f.setAccessible(true);
                try {
                    if(f.get(KeyEvent.class).equals(key)){
                        return KeyCode.getKeyCode(f.getName().replace("VK_", ""));
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        throw new IllegalArgumentException("Invalid key code: " + key);
    }



    public synchronized void poll() {
        for( int i = 0; i < keys.length; ++i ) {
            if( keys[i] ) {
                polled[i]++;
            } else {
                polled[i] = 0;
            }
        }
    }

    public synchronized void keyPressed( KeyEvent e ) {
        int keyCode = e.getKeyCode();
        if( keyCode >= 0 && keyCode < keys.length ) {
            keys[ keyCode ] = true;
        }
    }

    public synchronized void keyReleased( KeyEvent e ) {
        int keyCode = e.getKeyCode();
        if( keyCode >= 0 && keyCode < keys.length ) {
            keys[ keyCode ] = false;
        }
    }

    public void keyTyped( KeyEvent e ) {
        // Not needed
    }
}
