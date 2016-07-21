package org.josedeleon.foodfinderguatemala.libs.base;

/**
 * Created by Jose on 15/07/2016.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
