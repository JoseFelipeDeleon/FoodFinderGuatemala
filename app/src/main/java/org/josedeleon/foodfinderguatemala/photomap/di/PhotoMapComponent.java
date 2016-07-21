package org.josedeleon.foodfinderguatemala.photomap.di;

import org.josedeleon.foodfinderguatemala.PhotoFeedAppModule;
import org.josedeleon.foodfinderguatemala.domain.di.DomainModule;
import org.josedeleon.foodfinderguatemala.libs.di.LibsModule;
import org.josedeleon.foodfinderguatemala.photomap.ui.PhotoMapFragment;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by Jose on 15/07/2016.
 */
@Singleton
@Component(modules = {PhotoMapModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface PhotoMapComponent {
    void inject(PhotoMapFragment target);
}
