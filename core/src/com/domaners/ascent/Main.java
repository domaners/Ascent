package com.domaners.ascent;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.domaners.ascent.screens.*;

public class Main extends ApplicationAdapter {

	Screens currentScreen;
	OrthographicCamera camera;

    int WINDOW_WIDTH = 500;
        int WINDOW_HEIGHT = 500;

	@Override
	public void create () {

		if (Gdx.app.getType() == Application.ApplicationType.Android) {
			int ANDROID_WIDTH = Gdx.graphics.getWidth();
			int ANDROID_HEIGHT = Gdx.graphics.getHeight();
			camera = new OrthographicCamera(ANDROID_WIDTH, ANDROID_HEIGHT);
			camera.translate(ANDROID_WIDTH/2, ANDROID_HEIGHT/2);
			camera.update();
		} else {
			camera = new OrthographicCamera(WINDOW_WIDTH, WINDOW_HEIGHT);
			camera.translate(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2);
			camera.update();
		}

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
