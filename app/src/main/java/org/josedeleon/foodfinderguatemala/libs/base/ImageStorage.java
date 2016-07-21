package org.josedeleon.foodfinderguatemala.libs.base;

import java.io.File;

/**
 * Created by Jose on 15/07/2016.
 */
public interface ImageStorage {
    String getImageUrl(String id);
    void upload(File file, String id, ImageStorageFinishedListener listener);
}
