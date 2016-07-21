package org.josedeleon.foodfinderguatemala.main.di;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import org.josedeleon.foodfinderguatemala.domain.FirebaseAPI;
import org.josedeleon.foodfinderguatemala.libs.base.EventBus;
import org.josedeleon.foodfinderguatemala.libs.base.ImageStorage;
import org.josedeleon.foodfinderguatemala.main.MainPresenter;
import org.josedeleon.foodfinderguatemala.main.MainPresenterImpl;
import org.josedeleon.foodfinderguatemala.main.MainRepository;
import org.josedeleon.foodfinderguatemala.main.MainRepositoryImpl;
import org.josedeleon.foodfinderguatemala.main.SessionInteractor;
import org.josedeleon.foodfinderguatemala.main.SessionInteractorImpl;
import org.josedeleon.foodfinderguatemala.main.UploadInteractor;
import org.josedeleon.foodfinderguatemala.main.UploadInteractorImpl;
import org.josedeleon.foodfinderguatemala.main.ui.MainView;
import org.josedeleon.foodfinderguatemala.main.ui.adapters.MainSectionsPagerAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Jose on 15/07/2016.
 */
@Module
public class MainModule {
    private MainView view;
    private String[] titles;
    private Fragment[] fragments;
    private FragmentManager fragmentManager;

    public MainModule(MainView view, String[] titles, Fragment[] fragments, FragmentManager fragmentManager) {
        this.view = view;
        this.titles = titles;
        this.fragments = fragments;
        this.fragmentManager = fragmentManager;
    }

    @Provides
    @Singleton
    MainView providesMainView(){
        return this.view;
    }

    @Provides
    @Singleton
    MainPresenter providesMainPresenter(MainView view, EventBus eventBus, UploadInteractor uploadInteractor, SessionInteractor sessionInteractor){
        return new MainPresenterImpl(view, eventBus, uploadInteractor, sessionInteractor);
    }

    @Provides
    @Singleton
    UploadInteractor providesUploadInteractor(MainRepository repository){
        return new UploadInteractorImpl(repository);
    }

    @Provides
    @Singleton
    SessionInteractor providesSessionInteractor(MainRepository repository){
        return new SessionInteractorImpl(repository);
    }

    @Provides
    @Singleton
    MainRepository providesMainRepository(EventBus eventBus, FirebaseAPI firebase, ImageStorage imageStorage){
        return new MainRepositoryImpl(eventBus, firebase, imageStorage);
    }

    @Provides
    @Singleton
    MainSectionsPagerAdapter providesMainSectionsPagerAdapter(FragmentManager fragment, String[] titles, Fragment[] fragments){
        return new MainSectionsPagerAdapter(fragment, titles, fragments);
    }

    @Provides
    @Singleton
    FragmentManager providesAdapterFragmentManager(){
        return this.fragmentManager;
    }

    @Provides
    @Singleton
    Fragment[] providesFragmentArrayForAdapter(){
        return this.fragments;
    }

    @Provides
    @Singleton
    String[] providesStringArrayForAdapter(){
        return this.titles;
    }
}
