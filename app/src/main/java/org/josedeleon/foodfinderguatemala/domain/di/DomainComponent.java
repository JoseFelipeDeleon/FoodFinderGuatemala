package org.josedeleon.foodfinderguatemala.domain.di;

import org.josedeleon.foodfinderguatemala.PhotoFeedAppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Jose on 15/07/2016.
 */
@Singleton
@Component(modules = {DomainModule.class, PhotoFeedAppModule.class})
public interface DomainComponent {

}
