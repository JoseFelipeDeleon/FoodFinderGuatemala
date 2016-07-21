package org.josedeleon.foodfinderguatemala.photolist.ui.adapters;

import android.widget.ImageView;

import org.josedeleon.foodfinderguatemala.entities.Photo;


/**
 * Created by Jose on 15/07/2016.
 */
public interface OnItemClickListener {
    void onPlaceClick(Photo photo);
    void onShareClick(Photo photo, ImageView img);
    void onDeleteClick(Photo photo);
}
