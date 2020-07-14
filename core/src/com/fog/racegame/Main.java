package com.fog.racegame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.fog.racegame.views.GameScreen;

public class Main extends Game {

	@Override
	public void create () {
		Screen gameScreen = new GameScreen();
		setScreen(gameScreen);
	}
}
