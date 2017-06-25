package com.domaners.ascent.objects;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by adamn on 25/06/2017.
 */

public interface GameObject {

    Sprite getCurrentFrame();

    float getX();
    float getY();
    float getWidth();
    float getHeight();

}
