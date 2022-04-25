package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Leer;
import model.Persona;

public class GenerateDates extends Stage{

	private static Leer read;
	private  Button saveGenerationBotton;
	private  Button GenerationBotton;
	private static TextField numRandom;

	public GenerateDates() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GenerateDates.fxml"));
			Parent root;
			root = loader.load();
			Scene scene = new Scene(root, 304, 189);
			setScene(scene);

			saveGenerationBotton = (Button) loader.getNamespace().get("saveGenerationBotton");
			GenerationBotton = (Button) loader.getNamespace().get("GenerationBotton");
			numRandom = (TextField) loader.getNamespace().get("numRandom");

			init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	private void init() {

		GenerationBotton.setOnAction(event->{

			String x=numRandom.getText();
			int num=Integer.parseInt(x);
			if(num<=0) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("ERROR");
				alert.setHeaderText("NUMERO NO VALIDO");
				alert.setContentText("El numero que ingresaste no es valido, por favor ingresa un numero mayor a 0");

				alert.showAndWait();
			}else {
				read=new Leer(num);

				read.start();;
			}

		});	
		saveGenerationBotton.setOnAction(event->{
			MainWindow main = new MainWindow();
			main.show();
			this.close();

		});
	}


}
