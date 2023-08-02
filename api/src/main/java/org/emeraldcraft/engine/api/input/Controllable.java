package org.emeraldcraft.engine.api.input;

import javafx.scene.input.KeyCode;

import java.util.List;

public interface Controllable {
    void onKeyboardInput(List<KeyCode> keys);
}
