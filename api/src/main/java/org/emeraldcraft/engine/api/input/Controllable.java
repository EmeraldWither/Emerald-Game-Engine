package org.emeraldcraft.engine.api.input;

import java.util.List;

/**
 * Represents a gameobject which can be controlled
 */
public interface Controllable {
    /**
     * Called before every game tick if there is input from the keyboard
     *
     * @param keys inputs
     */
    void onKeyboardInput(List<KeyCode> keys);
}
