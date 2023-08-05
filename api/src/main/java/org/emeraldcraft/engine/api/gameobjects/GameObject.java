package org.emeraldcraft.engine.api.gameobjects;

import lombok.Getter;
import org.emeraldcraft.engine.api.internal.GameInstance;
import org.emeraldcraft.engine.api.render.ImageAsset;
import org.emeraldcraft.engine.api.render.Renderer;
import org.emeraldcraft.engine.api.utils.Logger;

import java.awt.*;

/**
 * Represents a basic gameobject.
 * Should be inherited.
 */
public abstract class GameObject {
    @Getter
    private final String name;
    /**
     * Allows the game object to modify its position, and specify a hitbox
     */
    @Getter
    private final Location location;
    @Getter
    private final int renderPriority;

    protected ImageAsset imageAsset;

    /**
     * @param name           The name of the gameobject
     * @param hitbox         A rectangle specifying the hitbox and point
     * @param renderPriority The lower the number, the closer it to the front. Must be at least 1
     */
    public GameObject(String name, Rectangle hitbox, int renderPriority) {
        this.name = name;
        this.location = new Location(new HitBox(hitbox.width, hitbox.height, this));
        this.renderPriority = renderPriority;
        GameInstance.getGameManager().registerGameObject(this);
        Logger.log("Created a new GameObject of: " + this);
    }

    /**
     * @return True if the game object should be removed
     */
    public abstract boolean shouldRemove();

    /**
     * Removes the game object from being ticked.
     */
    public void remove() {
        Logger.log(this + " has been deregistered and has been removed.");
        GameInstance.getGameManager().deRegisterGameObject(this);
    }


    @Override
    public String toString() {
        return "GameObject { name: \"" + name + "\", Location: " + getLocation().toString() + "}";
    }
    public void setImageAsset(ImageAsset imageAsset){
        this.imageAsset = imageAsset;
    }
    public void render(Graphics g){
        //Can be optionally overridden
    }
    public abstract void onDraw(Renderer renderer);

    public HitBox getHitBox(){
        return location.getHitbox();
    }

    public abstract void tick();
}