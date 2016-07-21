package org.josedeleon.foodfinderguatemala.main.di;

import org.josedeleon.foodfinderguatemala.PhotoFeedAppModule;
import org.josedeleon.foodfinderguatemala.domain.di.DomainModule;
import org.josedeleon.foodfinderguatemala.libs.di.LibsModule;
import org.josedeleon.foodfinderguatemala.main.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by Jose on 15/07/2016.
 */
@Singleton
@Component(modules = {MainModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
