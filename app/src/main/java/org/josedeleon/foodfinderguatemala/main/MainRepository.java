package org.josedeleon.foodfinderguatemala.main;

import android.location.Location;

/**
 * Created by Jose on 16/07/2016.
 */
public interface MainRepository {
    void logout();
    void uploadPhoto(Location location, String path);
}
