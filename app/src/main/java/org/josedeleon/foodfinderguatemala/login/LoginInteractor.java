package org.josedeleon.foodfinderguatemala.login;

/**
 * Created by Jose on 06/07/2016.
 */
public interface LoginInteractor {
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);
}
