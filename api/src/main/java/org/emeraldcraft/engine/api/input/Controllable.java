package org.emeraldcraft.engine.api.input;

import java.util.List;

public interface Controllable {
    void onKeyboardInput(List<KeyCode> keys);
}
