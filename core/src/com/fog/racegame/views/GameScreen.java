package com.fog.racegame.views;

/* Kirils Smirnovs created on 14-Jul-20 inside the package - com.fog.racegame.views */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fog.racegame.models.Chevrolet;
import com.fog.racegame.models.Tree;

public class GameScreen implements Screen {

    private Texture carTexture;
    private Texture treeTexture;
    private SpriteBatch batch;
    private Chevrolet chevrolet;
    private Tree tree1;
    private Tree tree2;
    private OrthographicCamera camera;

    public static float deltaCFF;

    @Override
    public void show() {
        batch = new SpriteBatch();
        carTexture = new Texture(Gdx.files.internal("zhuzhik.png"));
        carTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        chevrolet = new Chevrolet(carTexture, 0, 0, 1f , 1f * 2.1f);
        treeTexture = new Texture(Gdx.files.internal("tree.png"));
        treeTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        tree1 = new Tree(treeTexture, 1,1, 1f,1f);
        tree2 = new Tree(treeTexture, -1,-2, 1f,1f);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        deltaCFF = delta;

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        tree1.draw(batch);
        tree2.draw(batch);
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
