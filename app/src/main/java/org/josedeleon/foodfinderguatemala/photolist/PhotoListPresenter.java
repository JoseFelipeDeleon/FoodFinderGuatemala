package org.josedeleon.foodfinderguatemala.photolist;


import org.josedeleon.foodfinderguatemala.entities.Photo;
import org.josedeleon.foodfinderguatemala.photolist.events.PhotoListEvent;

/**
 * Created by Jose on 15/07/2016.
 */
public interface PhotoListPresenter {
    void onCreate();
    void onDestroy();

    void subscribe();
    void unsubscribe();

    void removePhoto(Photo photo);
    void onEventMainThread(PhotoListEvent event);
}
