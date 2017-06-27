package com.domaners.ascent.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.domaners.ascent.Statics;
import com.domaners.ascent.inputs.GameInput;

public class Player implements GameObject {

    private Sprite currentFrame;
    private GameInput input;

    private float x, y, width, height, xBoundary, yBoundary, xMomentum;

    private int playerScore;

    public Player() {

        currentFrame = new Sprite(new Texture(Gdx.files.internal("Ship-no-flame.png")));
        input = new GameInput(this);
        width = Statics.WIDTH_UNIT * 20;
        height = Statics.HEIGHT_UNIT * 20;
        x = (Statics.WIDTH_UNIT * 100) - width / 2;
        y = 100;
        xBoundary = Statics.WINDOW_WIDTH - this.width;
        yBoundary = Statics.HEIGHT_UNIT * 40;
        playerScore = 0;

    }

    public void renderFunctions(int gameSpeed) {
        input.handleInput();
        incrementPlayerScore(gameSpeed);
    }

    public Sprite getCurrentFrame() {
        return currentFrame;
    }

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

    public float getY() {
        return this.y;
    }

    @Override
    public void setY(float y) {
        if(y > yBoundary) {
            this.y = yBoundary;
        } else if(y < 0) {
            this.y = 0;
        } else {
            this.y = x;
        }
    }

    public float getWidth() {
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }

    public void setXMomentum(float increment) {

        this.xMomentum += increment;
        float x = this.getX();

        if(x >= xBoundary && this.xMomentum > 0)
            this.xMomentum = 0;
        else if (x <= 0 && this.xMomentum < 0)
            this.xMomentum = 0;

        this.setX(x + this.xMomentum);

    }

    public float getxMomentum() {
        return this.xMomentum;
    }

    public int getPlayerScore() {
        return this.playerScore;
    }

    public void incrementPlayerScore(int playerScore) {
        this.playerScore = this.playerScore + playerScore;
    }

}
