package com.fog.racegame.views;

/* Kirils Smirnovs created on 14-Jul-20 inside the package - com.fog.racegame.views */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fog.racegame.models.Chevrolet;

public class GameScreen implements Screen {

    private Texture carTexture;
    private SpriteBatch batch;
    private Chevrolet chevrolet;
    private OrthographicCamera camera;

    public static float deltaCFF;

    @Override
    public void show() {
        batch = new SpriteBatch();
        carTexture = new Texture(Gdx.files.internal("zhuzhik.jpg"));
        carTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        chevrolet = new Chevrolet(carTexture, 0, 0, 3f , 3f * 2.1f);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        deltaCFF = delta;

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        chevrolet.draw(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) height / width;
        camera = new OrthographicCamera(20f , 20f * aspectRatio);
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
