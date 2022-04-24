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
			generateDates();

		});	
		saveGenerationBotton.setOnAction(event->{
			MainWindow main = new MainWindow();
			main.show();
			this.close();

		});
	}

	public static String autoGenerateLastnames(ArrayList<String> lastnames) {
		int indiceAleatorio = numeroAleatorioEnRango(0, lastnames.size() - 1);
		String RandomLastname = lastnames.get(indiceAleatorio);
		return RandomLastname;
	}

	public static String autoGeneraNames(ArrayList<String> name) {
		int indiceAleatorio = numeroAleatorioEnRango(0, name.size() - 1);
		String RandomName = name.get(indiceAleatorio);
		return RandomName;
	}

	public static String autoGenerateCountris(ArrayList<String> pais) {
		int indiceAleatorio = numeroAleatorioEnRango(0, pais.size() - 1);
		String RandomCountri = pais.get(indiceAleatorio);
		return RandomCountri;
	}

	public static int numeroAleatorioEnRango(int minimo, int maximo) {
		// nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
		return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
	}

	public static void generateDates() {
		
		String x=numRandom.getText();
		int num=Integer.parseInt(x);

		if(num<=0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("NUMERO NO VALIDO");
			alert.setContentText("El numero que ingresaste no es valido, por favor ingresa un numero mayor a 0");

			alert.showAndWait();
		}else {
			ArrayList<String> name=read.readNames();
			ArrayList<String> lastname=read.readLastNames();
			ArrayList<String> country= read.readCountris();
			for(int i =0;i<num;i++) {
				
				Persona p=new Persona(autoGeneraNames(name), autoGenerateLastnames(lastname), "",autoGenerateCountris(country), "", "");
				//next
			}
		}
	}
}
