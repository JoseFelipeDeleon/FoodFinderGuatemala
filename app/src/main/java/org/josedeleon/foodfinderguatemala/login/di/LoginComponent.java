package org.josedeleon.foodfinderguatemala.login.di;

import org.josedeleon.foodfinderguatemala.PhotoFeedAppModule;
import org.josedeleon.foodfinderguatemala.domain.di.DomainModule;
import org.josedeleon.foodfinderguatemala.libs.di.LibsModule;
import org.josedeleon.foodfinderguatemala.login.ui.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by Jose on 15/07/2016.
 */

@Singleton
@Component(modules = {LoginModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface LoginComponent {
    void inject(LoginActivity activity);
}

