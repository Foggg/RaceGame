package com.fog.racegame.models;
/* KirilsSmirnovs created on 14-Jul-20 inside the package - com.fog.racegame.models */

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fog.racegame.controls.CarController;

public class Chevrolet extends GameObject{

    private CarController carController;

    public Chevrolet(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        carController = new CarController(bounds);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        carController.handle();
    }
}
