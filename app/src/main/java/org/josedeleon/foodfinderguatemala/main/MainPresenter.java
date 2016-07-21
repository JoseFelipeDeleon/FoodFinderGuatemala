package org.josedeleon.foodfinderguatemala.main;

import android.location.Location;

import org.josedeleon.foodfinderguatemala.main.events.MainEvent;

/**
 * Created by Jose on 16/07/2016.
 */
public interface MainPresenter {
    void onCreate();
    void onDestroy();

    void logout();
    void uploadPhoto(Location location, String path);
    void onEventMainThread(MainEvent event);


}
