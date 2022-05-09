package ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	/*
	 * Autores:
	 * Cristian Cardona
	 * Jesus Garces 
	 * Estefania Gonzales
	 */

	public static void main(String[] args) {
		
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		MainWindow main = new MainWindow();
		main.show();
	}

}