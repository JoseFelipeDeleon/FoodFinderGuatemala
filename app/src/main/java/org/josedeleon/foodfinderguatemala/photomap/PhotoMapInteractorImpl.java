package org.josedeleon.foodfinderguatemala.photomap;

/**
 * Created by Jose on 15/07/2016.
 */
public class PhotoMapInteractorImpl implements PhotoMapInteractor {
    private PhotoMapRepository repository;

    public PhotoMapInteractorImpl(PhotoMapRepository repository) {
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
}
