package org.josedeleon.foodfinderguatemala.libs.di;

import org.josedeleon.foodfinderguatemala.PhotoFeedAppModule;
import org.josedeleon.foodfinderguatemala.domain.di.DomainModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by Jose on 15/07/2016.
 */

@Singleton
@Component(modules = {LibsModule.class, PhotoFeedAppModule.class})
public interface LibsComponent {

}
