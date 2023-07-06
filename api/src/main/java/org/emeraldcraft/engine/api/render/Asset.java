package org.emeraldcraft.engine.api.render;

import lombok.Getter;

import java.io.File;

public class Asset {
    @Getter
    private final File asset;
    @Getter
    private final AssetType assetType;
    public Asset(File asset, AssetType assetType) {
        this.asset = asset;
        if(!asset.exists()){
            throw new IllegalArgumentException("The asset does not exist at " + asset.getAbsolutePath());
        }
        this.assetType = assetType;
    }

    public enum AssetType{
        IMAGE,
        SOUND
    }
}
