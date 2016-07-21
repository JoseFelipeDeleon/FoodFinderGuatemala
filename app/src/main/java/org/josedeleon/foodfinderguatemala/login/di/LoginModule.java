package org.josedeleon.foodfinderguatemala.login.di;

import org.josedeleon.foodfinderguatemala.domain.FirebaseAPI;
import org.josedeleon.foodfinderguatemala.libs.base.EventBus;
import org.josedeleon.foodfinderguatemala.login.LoginInteractor;
import org.josedeleon.foodfinderguatemala.login.LoginInteractorImpl;
import org.josedeleon.foodfinderguatemala.login.LoginPresenter;
import org.josedeleon.foodfinderguatemala.login.LoginPresenterImpl;
import org.josedeleon.foodfinderguatemala.login.LoginRepository;
import org.josedeleon.foodfinderguatemala.login.LoginRepositoryImpl;
import org.josedeleon.foodfinderguatemala.login.ui.LoginView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jose on 15/07/2016.
 */
@Module
public class LoginModule {
    LoginView view;

    public LoginModule(LoginView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    LoginView providesLoginView(){
        return this.view;
    }

    @Provides
    @Singleton
    LoginPresenter providesLoginPresenter(EventBus eventBus, LoginView loginView, LoginInteractor loginInteractor){
        return new LoginPresenterImpl(eventBus, loginView, loginInteractor);
    }

    @Provides
    @Singleton
    LoginInteractor providesLoginInteractor(LoginRepository repository){
        return new LoginInteractorImpl(repository);
    }

    @Provides
    @Singleton
    LoginRepository providesLoginRepository(EventBus eventBus, FirebaseAPI firebase){
        return new LoginRepositoryImpl(eventBus, firebase);
    }
}
