package org.josedeleon.foodfinderguatemala.photolist.di;

import org.josedeleon.foodfinderguatemala.domain.FirebaseAPI;
import org.josedeleon.foodfinderguatemala.domain.Util;
import org.josedeleon.foodfinderguatemala.entities.Photo;
import org.josedeleon.foodfinderguatemala.libs.base.EventBus;
import org.josedeleon.foodfinderguatemala.libs.base.ImageLoader;
import org.josedeleon.foodfinderguatemala.photolist.PhotoListInteractor;
import org.josedeleon.foodfinderguatemala.photolist.PhotoListInteractorImpl;
import org.josedeleon.foodfinderguatemala.photolist.PhotoListPresenter;
import org.josedeleon.foodfinderguatemala.photolist.PhotoListPresenterImpl;
import org.josedeleon.foodfinderguatemala.photolist.PhotoListRepository;
import org.josedeleon.foodfinderguatemala.photolist.PhotoListRepositoryImpl;
import org.josedeleon.foodfinderguatemala.photolist.ui.PhotoListView;
import org.josedeleon.foodfinderguatemala.photolist.ui.adapters.OnItemClickListener;
import org.josedeleon.foodfinderguatemala.photolist.ui.adapters.PhotoListAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Jose on 15/07/2016.
 */
@Module
public class PhotoListModule {
    private PhotoListView view;
    private OnItemClickListener onItemClickListener;

    public PhotoListModule(PhotoListView view, OnItemClickListener onItemClickListener) {
        this.view = view;
        this.onItemClickListener = onItemClickListener;
    }

    @Provides
    @Singleton
    PhotoListView providesPhotoListView(){
        return this.view;
    }

    @Provides
    @Singleton
    PhotoListPresenter providesPhotoListPresenter(EventBus eventBus, PhotoListView view, PhotoListInteractor interactor){
        return new PhotoListPresenterImpl(eventBus, view, interactor);
    }

    @Provides
    @Singleton
    PhotoListInteractor providesPhotoListInteractor(PhotoListRepository repository){
        return new PhotoListInteractorImpl(repository);
    }

    @Provides
    @Singleton
    PhotoListRepository providesPhotoListRepository(EventBus eventBus, FirebaseAPI firebase){
        return new PhotoListRepositoryImpl(eventBus, firebase);
    }

    @Provides
    @Singleton
    PhotoListAdapter providesPhotoListAdapter(Util util, List<Photo> photoList, ImageLoader imageLoader, OnItemClickListener onItemClickListener){
        return new PhotoListAdapter(util, photoList, imageLoader, onItemClickListener);
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.onItemClickListener;
    }

    @Provides
    @Singleton
    List<Photo> providesPhotoList(){
        return new ArrayList<Photo>();
    }

}
