package com.domaners.ascent;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;
import com.domaners.ascent.screens.*;

public class Main extends ApplicationAdapter {

	Screens currentScreen;
	long lastRefresh; // Time the screen was last rendered

	@Override
	public void create () {

		lastRefresh = TimeUtils.millis();
        Gdx.graphics.setWindowedMode(Statics.WINDOW_WIDTH, Statics.WINDOW_HEIGHT);
		currentScreen = new GameScreen();

	}

	@Override
	public void render () {

		// Limits the GameObject.render() method to 30FPS
		if (TimeUtils.timeSinceMillis(lastRefresh) > Statics.REFRESH_RATE) {
			lastRefresh = TimeUtils.millis();
			currentScreen.render();
		}

	}
	
	@Override
	public void dispose () {
		currentScreen.dispose();
	}
}
