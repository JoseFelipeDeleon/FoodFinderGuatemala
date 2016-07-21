package org.josedeleon.foodfinderguatemala.login.ui;

/**
 * Created by Jose on 06/07/2016.
 */
public interface LoginView {
    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();

    void handleSignUp();
    void handleSignIn();

    void navigateToMainScreen();
    void loginError(String error);

    void newUserSucces();

    void newUserSuccess();

    void newUserError(String error);

    void setUserEmail(String email);
}
