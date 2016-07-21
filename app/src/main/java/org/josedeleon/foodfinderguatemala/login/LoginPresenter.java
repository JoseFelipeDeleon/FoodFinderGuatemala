package org.josedeleon.foodfinderguatemala.login;


import org.josedeleon.foodfinderguatemala.login.events.LoginEvent;

/**
 * Created by Jose on 06/07/2016.
 */
public interface LoginPresenter {
    void onCreate();
    void onDestroy();
    void validateLogin(String email, String password);
    void registerNewUser(String email, String password);
    void onEventMainThread(LoginEvent event);
}
