package org.josedeleon.foodfinderguatemala.photomap;

import org.greenrobot.eventbus.Subscribe;
import org.josedeleon.foodfinderguatemala.libs.base.EventBus;
import org.josedeleon.foodfinderguatemala.photomap.events.PhotoMapEvent;
import org.josedeleon.foodfinderguatemala.photomap.ui.PhotoMapView;


/**
 * Created by Jose on 15/07/2016.
 */
public class PhotoMapPresenterImpl implements PhotoMapPresenter {
    private EventBus eventBus;
    private PhotoMapView view;
    private PhotoMapInteractor interactor;

    public PhotoMapPresenterImpl(EventBus eventBus, PhotoMapView view, PhotoMapInteractor interactor) {
        this.eventBus = eventBus;
        this.view = view;
        this.interactor = interactor;
    }

    @Override
    public void onCreate() {
        eventBus.register(this);
    }

    @Override
    public void onDestroy() {
        view = null;
        eventBus.unregister(this);
    }

    @Override
    public void subscribe() {
        interactor.subscribe();
    }

    @Override
    public void unsubscribe() {
        interactor.unsubscribe();
    }

    @Override
    @Subscribe
    public void onEventMainThread(PhotoMapEvent event) {
        if(view != null){
            if(event.getError() != null){
                view.onPhotosError(event.getError());
            } else {
                if (event.getType() == PhotoMapEvent.READ_EVENT){
                    view.addPhoto(event.getPhoto());
                } else if (event.getType() == PhotoMapEvent.DELETE_EVENT){
                    view.removePhoto(event.getPhoto());
                }
            }
        }
    }
}
