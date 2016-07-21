package org.josedeleon.foodfinderguatemala.photomap.events;


import org.josedeleon.foodfinderguatemala.entities.Photo;

/**
 * Created by Jose on 15/07/2016.
 */
public class PhotoMapEvent {
    private int type;
    private Photo photo;
    private String error;

    public static final int READ_EVENT = 0;
    public static final int DELETE_EVENT = 1;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Photo getPhoto() {
        return photo;
    }

    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
