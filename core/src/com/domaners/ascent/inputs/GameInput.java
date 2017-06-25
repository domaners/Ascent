package com.domaners.ascent.inputs;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;

public class GameInput {

    public void handleInput() {
        if(Gdx.app.getType() == Application.ApplicationType.Android) {
            androidInput();
        } else {
            keyboardInput();
        }
    }

    public void androidInput() {

    }

    public void keyboardInput() {

    }

}
