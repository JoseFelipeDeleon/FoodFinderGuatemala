package org.josedeleon.foodfinderguatemala.photolist;


import org.josedeleon.foodfinderguatemala.entities.Photo;

/**
 * Created by Jose on 15/07/2016.
 */
public interface PhotoListInteractor {
    void subscribe();
    void unsubscribe();
    void removePhoto(Photo photo);
}
