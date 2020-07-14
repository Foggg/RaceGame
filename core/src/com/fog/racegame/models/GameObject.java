package com.fog.racegame.models;
/* KirilsSmirnovs created on 14-Jul-20 inside the package - com.fog.racegame.models */


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject {

    Rectangle bounds;
    Sprite object;

    public GameObject(Texture texture, float x, float y, float width, float height){
        bounds = new Rectangle(x ,y, width, height);
        object = new Sprite(texture);
    }

    public void draw(SpriteBatch batch){
        object.setBounds(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
        object.draw(batch);
    }

}
