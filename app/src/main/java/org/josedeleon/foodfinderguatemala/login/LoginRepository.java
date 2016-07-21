package org.josedeleon.foodfinderguatemala.login;

/**
 * Created by Jose on 06/07/2016.
 */
public interface LoginRepository {
    void signUp(String email, String password);
    void signIn(String email, String password);
}
