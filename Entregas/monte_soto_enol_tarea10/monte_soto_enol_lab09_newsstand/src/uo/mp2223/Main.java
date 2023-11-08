package uo.mp2223;

import java.io.IOException;

import uo.mp2223.newsstand.ui.UserInterface;

public class Main {

	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	private void run() throws IOException {
		new UserInterface().show();
	}

}
