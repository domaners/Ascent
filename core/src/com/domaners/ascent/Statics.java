package com.domaners.ascent;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

/**
 * Houses all static variables across the application for easy accessibility.
 */
public class Statics {

    public static int WINDOW_WIDTH, WINDOW_HEIGHT;
    public static float WIDTH_UNIT, HEIGHT_UNIT;
    public static long REFRESH_RATE;

    static {
        if (Gdx.app.getType() == Application.ApplicationType.Android) {
            WINDOW_WIDTH = Gdx.graphics.getWidth();
            WINDOW_HEIGHT = Gdx.graphics.getHeight();
        } else {
            WINDOW_WIDTH = 540;
            WINDOW_HEIGHT = 960;
        }

        WIDTH_UNIT = WINDOW_WIDTH / 100;
        HEIGHT_UNIT = WINDOW_HEIGHT / 100;

        REFRESH_RATE = 1L / 30L;
    }

}
