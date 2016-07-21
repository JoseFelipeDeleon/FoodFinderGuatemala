package org.josedeleon.foodfinderguatemala.photomap.ui;


import org.josedeleon.foodfinderguatemala.entities.Photo;

/**
 * Created by Jose on 15/07/2016.
 */
public interface PhotoMapView {
    void addPhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);
}
