package com.fog.racegame.controls;
/* KirilsSmirnovs created on 14-Jul-20 inside the package - com.fog.racegame.controls */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.fog.racegame.views.GameScreen;

public class CarController {

    private Polygon carBounds;
    private float carSpeed;
    private float speedVelocity = 10f;
    private float speedMax = 10f;
    private float rotationSpeed = 30f;

    public CarController(Polygon carBounds) {
        this.carBounds = carBounds;
    }

    public void handle() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            carSpeed += speedVelocity * GameScreen.deltaCFF;
        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            carSpeed -= speedVelocity * GameScreen.deltaCFF;
        }
        else{
            downSpeed();
        }
        carSpeed = sliceSpeed();

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            carBounds.rotate(rotationSpeed * carSpeed * GameScreen.deltaCFF);
        } else if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            carBounds.rotate(-rotationSpeed * carSpeed * GameScreen.deltaCFF);
        }


        carBounds.setPosition(carBounds.getX() + MathUtils.cosDeg(carBounds.getRotation() + 90) * carSpeed * GameScreen.deltaCFF,
                carBounds.getY() + MathUtils.sinDeg(carBounds.getRotation() + 90) * carSpeed * GameScreen.deltaCFF);


        if (carBounds.getX() >= 8 || carBounds.getY() >= 3) {
            carSpeed = -1f;
            carBounds.setPosition(carBounds.getX(),carBounds.getY());
        }
        if(carBounds.getX() <= -10 || carBounds.getY() <= -5){
            carSpeed = 1f;
            carBounds.setPosition(carBounds.getX(),carBounds.getY());
        }
    }

    private void downSpeed() {
        if (carSpeed > speedVelocity * GameScreen.deltaCFF) {
            carSpeed -= speedVelocity * GameScreen.deltaCFF;
        }
        else if (carSpeed < -speedVelocity * GameScreen.deltaCFF) {
            carSpeed += speedVelocity * GameScreen.deltaCFF;
        }
        else {
            carSpeed = 0f;
        }
    }

    private float sliceSpeed() {
        if (carSpeed > speedMax) {
            return speedMax;
        }
        return Math.max(carSpeed, -speedMax);
    }
}
