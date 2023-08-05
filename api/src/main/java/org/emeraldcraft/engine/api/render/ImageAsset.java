package org.emeraldcraft.engine.api.render;

import lombok.Getter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Represents an Asset that is an image.
 */
public class ImageAsset extends Asset {
    @Getter
    private final Image image;
    public ImageAsset(String assetName) {
        super(new File("assets/" + assetName), AssetType.IMAGE);
        if (!isImage()) throw new IllegalArgumentException("The asset is not a file. (must be a .jpeg, .jpg, .png)");
        try {
            this.image = ImageIO.read(getAsset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isImage() {
        String name = getAsset().getName();
        return name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".jpeg");
    }
}
