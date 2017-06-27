package com.domaners.ascent.inputs;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.domaners.ascent.Statics;
import com.domaners.ascent.objects.Player;

public class GameInput {

    Player player;

    public GameInput (Player player) {
        this.player = player;
    }

    public void handleInput() {
        if(Gdx.app.getType() == Application.ApplicationType.Android) {
            androidInput();
        } else {
            keyboardInput();
        }
    }

    public void androidInput() {
        float screenCentre = Gdx.app.getGraphics().getWidth() / 2;
        float touchX = Gdx.input.getX();

        if(Gdx.input.isTouched()) {
            if (touchX <= screenCentre) {
                player.setXMomentum(-Statics.X_MOMENTUM);
            } else {
                player.setXMomentum(Statics.X_MOMENTUM);
            }
        } else {
            slowMomentum();
        }
    }

    public void keyboardInput() {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && !Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            player.setXMomentum(-Statics.X_MOMENTUM);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && !Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            player.setXMomentum(Statics.X_MOMENTUM);
        } else if (!Gdx.input.isKeyPressed(Input.Keys.LEFT) && !Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            slowMomentum();
        }

    }

    /*
    *   Slows the character down when left/right is not pressed
    */
    private void slowMomentum() {
        if(player.getxMomentum() < 0) {
            player.setXMomentum(Statics.X_MOMENTUM);
        } else if (player.getxMomentum() > 0) {
            player.setXMomentum(-Statics.X_MOMENTUM);
        } else if (player.getxMomentum() < Statics.X_MOMENTUM && player.getxMomentum() > -Statics.X_MOMENTUM) {
            player.setXMomentum(0F);
        }
    }

}
