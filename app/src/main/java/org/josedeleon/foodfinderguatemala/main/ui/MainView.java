package org.josedeleon.foodfinderguatemala.main.ui;

/**
 * Created by Jose on 16/07/2016.
 */
public interface MainView {
    void onUploadInit();
    void onUploadComplete();
    void onUploadError(String error);
}
