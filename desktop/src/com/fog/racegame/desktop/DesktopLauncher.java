package com.fog.racegame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.fog.racegame.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 1000;
		config.width = 2000;
		config.foregroundFPS = 15;
		config.vSyncEnabled = false;
		config.title = "Chevrolet Racing";
		new LwjglApplication(new Main(), config);
	}
}
