package com.domaners.ascent.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.domaners.ascent.Statics;

/**
 * Created by adamn on 27/06/2017.
 */
public class Planet implements GameObject {

    private Sprite currentFrame;
    private float x, y, width, height, xBoundary, yBoundary, xMomentum;

    public Planet(int version) {

        this.currentFrame = new Sprite(new Texture(Gdx.files.internal("PLANET" + version + ".png")));
        this.width = Statics.WIDTH_UNIT * 30;
        this.height = this.getWidth();
        this.xBoundary = Statics.WINDOW_WIDTH - this.width;

        this.setY(version * (Statics.WINDOW_HEIGHT));
        this.setX((float)(Math.random() * (Statics.WINDOW_WIDTH)));

    }

    @Override
    public Sprite getCurrentFrame() {
        return this.currentFrame;
    }

    @Override
    public float getX() {
        return this.x;
    }

    @Override
    public void setX(float x) {
        if(x > xBoundary) {
            this.x = xBoundary;
        } else if(x < 0) {
            this.x = 0;
        } else {
            this.x = x;
        }
    }

    @Override
    public float getY() {
        return this.y;
    }

    @Override
    public void setY(float y) {
        if(y < -(Statics.WINDOW_HEIGHT)) {
            this.y = Statics.WINDOW_HEIGHT * 8;
        } else {
            this.y = y;
        }
    }

    @Override
    public float getWidth() {
        return this.width;
    }

    @Override
    public float getHeight() {
        return this.height;
    }
}
