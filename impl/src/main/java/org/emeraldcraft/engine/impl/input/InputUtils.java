package org.emeraldcraft.engine.impl.input;

import org.emeraldcraft.engine.api.input.KeyCode;

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class InputUtils {
    public static KeyCode fromInt(int key){
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
}
