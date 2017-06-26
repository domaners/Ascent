package com.domaners.ascent.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.domaners.ascent.Statics;
import com.domaners.ascent.objects.Player;

/**
 * The main class used to render the current game session.
 * The render() method works as the game loop and constantly executes game logic and screen display
 */
public class GameScreen implements Screens {

    SpriteBatch batch;
    OrthographicCamera camera;
    Player player;

    public GameScreen() {

        camera = new OrthographicCamera(Statics.WINDOW_WIDTH, Statics.WINDOW_HEIGHT);
        camera.translate(Statics.WINDOW_WIDTH, Statics.WINDOW_HEIGHT);
        camera.update();

        batch = new SpriteBatch();

        player = new Player();

    }

    public void render() {

        player.renderFunctions();

        Gdx.gl.glClearColor(9, 6, 38, 1);
        batch.begin();
        batch.draw(player.getCurrentFrame(), player.getX(), player.getY(), player.getWidth(), player.getHeight());
        batch.end();

    }

    @Override
    public void dispose () {
        batch.dispose();
    }

}
