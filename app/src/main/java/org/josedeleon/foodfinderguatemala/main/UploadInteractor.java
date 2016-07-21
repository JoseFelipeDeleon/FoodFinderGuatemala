package org.josedeleon.foodfinderguatemala.main;

import android.location.Location;

/**
 * Created by Jose on 16/07/2016.
 */
public interface UploadInteractor {
    void execute(Location location, String path);
}
