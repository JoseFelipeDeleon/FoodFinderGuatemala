package org.josedeleon.foodfinderguatemala.photolist;


import org.josedeleon.foodfinderguatemala.entities.Photo;

/**
 * Created by Jose on 15/07/2016.
 */
public class PhotoListInteractorImpl implements PhotoListInteractor {
    private PhotoListRepository repository;

    public PhotoListInteractorImpl(PhotoListRepository repository) {
        this.repository = repository;
    }

    @Override
    public void subscribe() {
        repository.subscribe();
    }

    @Override
    public void unsubscribe() {
        repository.unsubscribe();
    }

    @Override
    public void removePhoto(Photo photo) {
        repository.removePhoto(photo);
    }
}
