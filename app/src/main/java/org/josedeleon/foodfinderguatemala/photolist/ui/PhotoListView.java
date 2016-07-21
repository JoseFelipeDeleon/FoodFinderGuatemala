package org.josedeleon.foodfinderguatemala.photolist.ui;


import org.josedeleon.foodfinderguatemala.entities.Photo;

/**
 * Created by Jose on 15/07/2016.
 */
public interface PhotoListView {
    void showList();
    void hideList();
    void showProgress();
    void hideProgress();

    void addPhoto(Photo photo);
    void removePhoto(Photo photo);
    void onPhotosError(String error);
}
