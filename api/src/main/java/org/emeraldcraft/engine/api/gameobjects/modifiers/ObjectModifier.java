package org.emeraldcraft.engine.api.gameobjects.modifiers;

import org.emeraldcraft.engine.api.gameobjects.GameObject;

public interface ObjectModifier {
    void onTick(GameObject gameObject);
}
