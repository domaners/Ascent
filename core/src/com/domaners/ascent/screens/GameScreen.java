package com.domaners.ascent.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.domaners.ascent.Statics;
import com.domaners.ascent.objects.Planet;
import com.domaners.ascent.objects.Player;

import java.util.ArrayList;

/**
 * The main class used to render the current game session.
 * The render() method works as the game loop and constantly executes game logic and screen display
 */
public class GameScreen implements Screens {

    SpriteBatch batch;
    OrthographicCamera camera;
    Player player;
    BitmapFont font = new BitmapFont();

    float gameSpeed;

    ArrayList<Planet> planets = new ArrayList<Planet>();

    public GameScreen() {

        camera = new OrthographicCamera(Statics.WINDOW_WIDTH, Statics.WINDOW_HEIGHT);
        camera.translate(Statics.WINDOW_WIDTH, Statics.WINDOW_HEIGHT);
        camera.update();

        batch = new SpriteBatch();

        player = new Player();

        gameSpeed = 10.0F;

        for(int i = 1; i < 10; i++) {
            planets.add(new Planet(i));
        }

    }

    public void render() {

        player.renderFunctions((int)gameSpeed);

        // TODO Get background colour working
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(9, 6, 38, 1);
        batch.begin();
        batch.draw(player.getCurrentFrame(), player.getX(), player.getY(), player.getWidth(), player.getHeight());

        for(Planet p: planets) {
            p.setY(p.getY() - gameSpeed);
            batch.draw(p.getCurrentFrame(), p.getX(), p.getY(), p.getWidth(), p.getHeight());
            font.draw(batch, "Score: " + player.getPlayerScore(), Statics.WIDTH_UNIT * 80, Statics.HEIGHT_UNIT * 95);
        }
        batch.end();

    }

    @Override
    public void dispose () {
        batch.dispose();
    }

}
