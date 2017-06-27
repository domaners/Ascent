package com.domaners.ascent.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by adamn on 25/06/2017.
 */

public interface GameObject {

    Sprite getCurrentFrame();

    float getX();
    void setX(float x);
    float getY();
    void setY(float y);
    float getWidth();
    float getHeight();

}
