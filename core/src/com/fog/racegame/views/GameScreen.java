package com.fog.racegame.views;

/* Kirils Smirnovs created on 14-Jul-20 inside the package - com.fog.racegame.views */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fog.racegame.models.Chevrolet;

public class GameScreen implements Screen {

    private Texture carTexture;
    private SpriteBatch batch;
    private Chevrolet chevrolet;

    @Override
    public void show() {
        batch = new SpriteBatch();
        carTexture = new Texture(Gdx.files.internal("zhuzhik.png"));
        chevrolet = new Chevrolet(carTexture, 0,0 ,400,146);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        chevrolet.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        carTexture.dispose();
        batch.dispose();
    }
}
