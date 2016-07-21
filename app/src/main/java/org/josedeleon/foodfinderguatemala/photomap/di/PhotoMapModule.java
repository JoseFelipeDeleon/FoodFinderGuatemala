package org.josedeleon.foodfinderguatemala.photomap.di;

import org.josedeleon.foodfinderguatemala.domain.FirebaseAPI;
import org.josedeleon.foodfinderguatemala.libs.base.EventBus;
import org.josedeleon.foodfinderguatemala.photomap.PhotoMapInteractor;
import org.josedeleon.foodfinderguatemala.photomap.PhotoMapInteractorImpl;
import org.josedeleon.foodfinderguatemala.photomap.PhotoMapPresenter;
import org.josedeleon.foodfinderguatemala.photomap.PhotoMapPresenterImpl;
import org.josedeleon.foodfinderguatemala.photomap.PhotoMapRepository;
import org.josedeleon.foodfinderguatemala.photomap.PhotoMapRepositoryImpl;
import org.josedeleon.foodfinderguatemala.photomap.ui.PhotoMapView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Jose on 15/07/2016.
 */
@Module
public class PhotoMapModule {
    private PhotoMapView view;

    public PhotoMapModule(PhotoMapView view) {
        this.view = view;
    }

    @Provides
    @Singleton
    PhotoMapView providesPhotoMapView(){
        return this.view;
    }

    @Provides
    @Singleton
    PhotoMapPresenter providesPhotoMapPresenter(EventBus eventBus, PhotoMapView view, PhotoMapInteractor interactor){
        return new PhotoMapPresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    PhotoMapInteractor providesPhotoMapInteractor(PhotoMapRepository repository){
        return new PhotoMapInteractorImpl(repository);
    }

    @Provides
    @Singleton
    PhotoMapRepository providesPhotoMapRepository(EventBus eventBus, FirebaseAPI firebaseAPI){
        return new PhotoMapRepositoryImpl(eventBus, firebaseAPI);
    }
}
