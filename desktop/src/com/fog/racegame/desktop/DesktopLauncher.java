package com.fog.racegame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.fog.racegame.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 854;
		config.width = 480;
		config.foregroundFPS = 15;
		config.vSyncEnabled = false;
		new LwjglApplication(new Main(), config);
	}
}
