package org.josedeleon.foodfinderguatemala.photomap;


import org.josedeleon.foodfinderguatemala.photomap.events.PhotoMapEvent;

/**
 * Created by Jose on 15/07/2016.
 */
public interface PhotoMapPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void onEventMainThread(PhotoMapEvent event);
}
