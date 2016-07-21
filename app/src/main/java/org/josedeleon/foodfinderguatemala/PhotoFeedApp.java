package org.josedeleon.foodfinderguatemala;

import android.app.Application;
import android.support.v4.app.FragmentManager;

import com.firebase.client.Firebase;


import org.josedeleon.foodfinderguatemala.domain.di.DomainModule;
import org.josedeleon.foodfinderguatemala.libs.di.LibsModule;
import org.josedeleon.foodfinderguatemala.login.di.DaggerLoginComponent;
import org.josedeleon.foodfinderguatemala.login.di.LoginComponent;
import org.josedeleon.foodfinderguatemala.login.di.LoginModule;
import org.josedeleon.foodfinderguatemala.login.ui.LoginView;
import org.josedeleon.foodfinderguatemala.main.di.DaggerMainComponent;
import org.josedeleon.foodfinderguatemala.main.di.MainComponent;
import org.josedeleon.foodfinderguatemala.main.di.MainModule;
import org.josedeleon.foodfinderguatemala.main.ui.MainView;
import org.josedeleon.foodfinderguatemala.photolist.di.DaggerPhotoListComponent;
import org.josedeleon.foodfinderguatemala.photolist.di.PhotoListComponent;
import org.josedeleon.foodfinderguatemala.photolist.di.PhotoListModule;
import org.josedeleon.foodfinderguatemala.photolist.ui.PhotoListFragment;
import org.josedeleon.foodfinderguatemala.photolist.ui.PhotoListView;
import org.josedeleon.foodfinderguatemala.photolist.ui.adapters.OnItemClickListener;
import org.josedeleon.foodfinderguatemala.photomap.di.DaggerPhotoMapComponent;
import org.josedeleon.foodfinderguatemala.photomap.di.PhotoMapComponent;
import org.josedeleon.foodfinderguatemala.photomap.di.PhotoMapModule;
import org.josedeleon.foodfinderguatemala.photomap.ui.PhotoMapFragment;
import org.josedeleon.foodfinderguatemala.photomap.ui.PhotoMapView;

import dagger.Module;

/**
 * Created by Jose on 14/07/2016.
 */
@Module
public class PhotoFeedApp extends Application {
    private final static String EMAIL_KEY = "email";
    private final static String SHARED_PREFERENCES_NAME = "UserPrefs";
    private final static String FIREBASE_URL = "https://buscadordecomida.firebaseio.com/";

    private DomainModule domainModule;
    private PhotoFeedAppModule photoFeedAppModule;

    @Override
    public void onCreate() {
        super.onCreate();
        initFirebase();
        initModules();
    }

    private void initModules() {
        photoFeedAppModule = new PhotoFeedAppModule(this);
        domainModule = new DomainModule(FIREBASE_URL);
    }

    private void initFirebase(){Firebase.setAndroidContext(this);}

    public String getEmailKey() {
        return EMAIL_KEY;
    }

    public String getSharedPreferencesName() {
        return SHARED_PREFERENCES_NAME;
    }

    public LoginComponent getLoginComponent(LoginView view){
        return DaggerLoginComponent
                .builder()
                .loginModule(new LoginModule(view))
                .domainModule(domainModule)
                .libsModule(new LibsModule(null))
                .photoFeedAppModule(photoFeedAppModule)
                .build();
    }

    public MainComponent getMainComponent(MainView view, FragmentManager manager, android.support.v4.app.Fragment[] fragments, String[] titles){
        return DaggerMainComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(new LibsModule(null))
                .mainModule(new MainModule(view, titles, fragments, manager))
                .build();
    }

    public PhotoListComponent getPhotoListComponent(PhotoListFragment fragment, PhotoListView view, OnItemClickListener onItemClickListener){
        return DaggerPhotoListComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(new LibsModule(fragment))
                .photoListModule(new PhotoListModule(view, onItemClickListener))
                .build();
    }

    public PhotoMapComponent getPhotoMapComponent(PhotoMapFragment fragment, PhotoMapView view) {
        return DaggerPhotoMapComponent
                .builder()
                .photoFeedAppModule(photoFeedAppModule)
                .domainModule(domainModule)
                .libsModule(new LibsModule(fragment))
                .photoMapModule(new PhotoMapModule(view))
                .build();
    }
}
