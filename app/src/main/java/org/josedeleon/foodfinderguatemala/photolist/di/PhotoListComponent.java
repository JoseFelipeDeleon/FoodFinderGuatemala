package org.josedeleon.foodfinderguatemala.photolist.di;

import org.josedeleon.foodfinderguatemala.PhotoFeedAppModule;
import org.josedeleon.foodfinderguatemala.domain.di.DomainModule;
import org.josedeleon.foodfinderguatemala.libs.di.LibsModule;
import org.josedeleon.foodfinderguatemala.photolist.ui.PhotoListFragment;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Created by Jose on 15/07/2016.
 */
@Singleton
@Component(modules = {PhotoListModule.class, DomainModule.class, LibsModule.class, PhotoFeedAppModule.class})
public interface PhotoListComponent {
    void inject(PhotoListFragment activity);
}
