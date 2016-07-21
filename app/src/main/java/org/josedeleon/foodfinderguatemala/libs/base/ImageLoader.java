package org.josedeleon.foodfinderguatemala.libs.base;

import android.widget.ImageView;

/**
 * Created by Jose on 15/07/2016.
 */
public interface ImageLoader {
    void load(ImageView imageView, String URL);
    void setOnFinishedImageLoadingListener(Object listener);
}
