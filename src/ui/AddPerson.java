package ui;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.AVL_Tree;
import model.Leer;
import model.Persona;

public class AddPerson extends Stage {

	private RadioButton rdbMale;
	private RadioButton rdbFem;

	private ImageView photo;

	private TextField tfName;
	private TextField tfLastName;
	private TextField pathFhoto;
	private TextField tfHeight;
	private TextField tfNacionality;

	private DatePicker dateBirthday;

	private Button btnBrowse;
	private Button btnUpload;
	private Button btnCancel;
	
	private Leer l;
	private AVL_Tree tree;

	public AddPerson() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddPerson.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 600, 400);
			setScene(scene);

			tfName = (TextField) loader.getNamespace().get("tfName");
			tfLastName = (TextField) loader.getNamespace().get("tfLastName");
			pathFhoto = (TextField) loader.getNamespace().get("pathFhoto");
			tfHeight = (TextField) loader.getNamespace().get("tfHeight");
			tfNacionality = (TextField) loader.getNamespace().get("tfNacionality");

			rdbMale = (RadioButton) loader.getNamespace().get("rdbMale");
			rdbFem = (RadioButton) loader.getNamespace().get("rdbFem");

			photo = (ImageView) loader.getNamespace().get("photo");

			dateBirthday = (DatePicker) loader.getNamespace().get("dateBirthday");

			btnBrowse = (Button) loader.getNamespace().get("btnBrowse");
			btnUpload = (Button) loader.getNamespace().get("btnUpload");
			btnCancel = (Button) loader.getNamespace().get("btnCancel");

			init();

		} catch (Exception ex) {

			ex.printStackTrace();
		}
	}

	public void init() {

		btnBrowse.setOnAction(event -> {
			photoPath();
		});

		btnUpload.setOnAction(event -> {
			
			if((tfName.getText() != null) && (tfLastName.getText() != null) && (tfHeight.getText() != null) &&
					((rdbMale.getText()!=null) || (rdbFem.getText()!=null)) && (tfNacionality.getText()!= null) &&
					(dateBirthday.getValue()!=null) && (pathFhoto!=null)) {
				
				createPerson();
				
			}
			else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("ERROR");
				alert.setHeaderText("No se pudo ingresar a la persona");
				alert.setContentText("Debes llenar todos los campos");
				alert.showAndWait();
				
			}

		});

		btnCancel.setOnAction(event -> {

			MainWindow main = new MainWindow();
			main.show();
			this.close();

		});

	}

	public void createPerson() {

		String name = tfName.getText();

		String lastName = tfLastName.getText();

		String gender = "";

		if (rdbMale.selectedProperty().get() == true) {

			gender = rdbMale.getText();
		}

		else if (rdbFem.selectedProperty().get() == true) {
			gender = rdbFem.getText();
		}

		String country = tfNacionality.getText();

		String birthDay = dateBirthday.getValue().toString();
		
		String pathPhoto = "";
		
		String heithg = tfHeight.getText();

		pathPhoto = pathFhoto.getText();
		
		int age = 2022 - (dateBirthday.getValue().getYear());
		
		String x = "";
		int cont = 0;
		String code = l.generatecode(x, cont);
		
		Persona p = new Persona(name, lastName, birthDay,country, pathPhoto, code, gender,age, heithg);
		tree.add(p.getCode().toString(), p);
		
		MainWindow main = new MainWindow();
		main.show();
		this.close();
		
	}

	public void photoPath() {
		FileChooser fc = new FileChooser();
		fc.setTitle("Abra una imagen");
		fc.getExtensionFilters().addAll(

				new FileChooser.ExtensionFilter("PNG", "*.png"), new FileChooser.ExtensionFilter("JPG", "*.jpg")

		);

		File file = fc.showOpenDialog(this);

		if (file != null) {
			Image image = new Image("file:" + file.getAbsolutePath());
			photo.setImage(image);
			pathFhoto.setText(file.getAbsolutePath());

		}

	}
	

}
