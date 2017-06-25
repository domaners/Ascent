package com.domaners.ascent;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.domaners.ascent.screens.*;

public class Main extends ApplicationAdapter {

	Screens currentScreen;

    public static int WINDOW_WIDTH, WINDOW_HEIGHT;
    public static float WIDTH_UNIT, HEIGHT_UNIT;

	@Override
	public void create () {

		if (Gdx.app.getType() == Application.ApplicationType.Android) {
			WINDOW_WIDTH = Gdx.graphics.getWidth();
			WINDOW_HEIGHT = Gdx.graphics.getHeight();
		} else {
            WINDOW_WIDTH = 540;
            WINDOW_HEIGHT = 960;
		}

		WIDTH_UNIT = WINDOW_WIDTH / 100;
		HEIGHT_UNIT = WINDOW_HEIGHT / 100;

        Gdx.graphics.setWindowedMode(WINDOW_WIDTH, WINDOW_HEIGHT);
		currentScreen = new GameScreen();
	}

	@Override
	public void render () {
		currentScreen.render();
	}
	
	@Override
	public void dispose () {
		currentScreen.dispose();
	}
}
