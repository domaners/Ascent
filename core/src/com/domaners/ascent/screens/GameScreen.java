package com.domaners.ascent.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.domaners.ascent.Main;

/**
 * The main class used to render the current game session.
 * The render() method works as the game loop and constantly executes game logic and screen display
 */
public class GameScreen implements Screens {

    SpriteBatch batch;
    Texture planet;
    OrthographicCamera camera;

    public GameScreen() {

        camera = new OrthographicCamera(Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        camera.translate(Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        camera.update();

        batch = new SpriteBatch();
        planet = new Texture(Gdx.files.internal("PLANET1.png"));

    }

    public void render() {

        Gdx.gl.glClearColor(9, 6, 38, 1);
        batch.begin();
        batch.end();

    }

    @Override
    public void dispose () {
        batch.dispose();
    }

}
