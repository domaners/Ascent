package com.domaners.ascent.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * The main class used to render the current game session.
 * The render() method works as the game loop and constantly executes game logic and screen display
 */
public class GameScreen implements Screens {

    SpriteBatch batch;
    Texture background, planet;

    public GameScreen() {
        batch = new SpriteBatch();
        background = new Texture("Background.png");
        planet = new Texture(Gdx.files.internal("PLANET1.png"));
    }

    public void render() {
        // Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(background, 0, 0);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        background.dispose();
    }

}
