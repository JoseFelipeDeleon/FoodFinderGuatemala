package org.josedeleon.foodfinderguatemala.libs;

import android.os.AsyncTask;
import android.view.View;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import org.josedeleon.foodfinderguatemala.libs.base.ImageStorage;
import org.josedeleon.foodfinderguatemala.libs.base.ImageStorageFinishedListener;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Jose on 15/07/2016.
 */
public class CloudinaryImageStorage implements ImageStorage {
    private Cloudinary cloudinary;

    public CloudinaryImageStorage(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String getImageUrl(String id) {
        return cloudinary.url().generate(id);
    }

    @Override
    public void upload(final File file, final String id, final ImageStorageFinishedListener listener) {
        new AsyncTask<Void, Void, Void>(){
            boolean succes = false;
            @Override
            protected Void doInBackground(Void... voids) {
                Map params = ObjectUtils.asMap("public_id", id);
                try {
                    cloudinary.uploader().upload(file, params);
                    succes = true;
                } catch (IOException e) {
                    listener.onError(e.getLocalizedMessage());
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                if(succes){
                    listener.onSucces();
                }
            }
        }.execute();
    }
}
