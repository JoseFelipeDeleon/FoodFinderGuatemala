package org.josedeleon.foodfinderguatemala.main.events;

/**
 * Created by Jose on 16/07/2016.
 */
public class MainEvent {
    private int type;
    private String error;

    public final static int UPLOAD_INIT = 0;
    public final static int UPLOAD_COMPLETE = 1;
    public final static int UPLOAD_ERROR = 2;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
