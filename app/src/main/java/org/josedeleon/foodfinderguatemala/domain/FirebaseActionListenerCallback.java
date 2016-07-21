package org.josedeleon.foodfinderguatemala.domain;

import com.firebase.client.FirebaseError;

/**
 * Created by Jose on 14/07/2016.
 */
public interface FirebaseActionListenerCallback {
    void onSuccess();
    void onError(FirebaseError error);
}
