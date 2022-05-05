package ui;

import java.io.File;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
import model.PersonList;
import model.Persona;

public class EditPerson extends Stage {
	private Leer l;
	private String coode;

	private TextField tfChName;
	private TextField tfChLastName;
	private TextField chPathPhoto;
	private TextField tfChHeight;

	private RadioButton rdbChMale;
	private RadioButton rdbChFem;

	private DatePicker dateChBirthday;

	private ImageView photo;

	private ComboBox<String> boxChNacionality;

	private Button btnBrowse;
	private Button btnCancel;
	private Button btnUpload;

	public static AVL_Tree instance;
	public static PersonList list;

	public EditPerson(String coode) {
		this.coode=coode;

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EditPerson.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 600, 400);
			setScene(scene);

			tfChName = (TextField) loader.getNamespace().get("tfChName");
			tfChName.setText(coode);
			tfChLastName = (TextField) loader.getNamespace().get("tfChLastName");
			chPathPhoto = (TextField) loader.getNamespace().get("chPathPhoto");
			tfChHeight = (TextField) loader.getNamespace().get("tfChHeight");

			rdbChMale = (RadioButton) loader.getNamespace().get("rdbChMale");
			rdbChFem = (RadioButton) loader.getNamespace().get("rdbChFem");

			photo = (ImageView) loader.getNamespace().get("photo");

			dateChBirthday = (DatePicker) loader.getNamespace().get("dateChBirthday");

			btnBrowse = (Button) loader.getNamespace().get("btnBrowse");
			btnUpload = (Button) loader.getNamespace().get("btnUpload");
			btnCancel = (Button) loader.getNamespace().get("btnCancel");

			instance=instance.getInstance();
			init();

		}catch(Exception ex) {
			ex.printStackTrace();

		}
	}

	public void init() throws NullPointerException{

		btnBrowse.setOnAction(event->{


		});

		btnUpload.setOnAction(event->{
			Persona x=list.changeInfo(coode);
			if(x!=null){
				if((tfChName.getText() != null) && (tfChLastName.getText() != null) && (tfChHeight.getText() != null) &&
						((rdbChMale.getText()!=null) || (rdbChFem.getText()!=null)) &&
						(dateChBirthday.getValue()!=null) && (photo!=null)) {

					changeInformation();
				}			else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("ERROR");
					alert.setHeaderText("No se pudo ingresar a la persona");
					alert.setContentText("Debes llenar todos los campos");
					alert.showAndWait();

				}
			}else{  Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("Invalid CODE");
			alert.setContentText("Your code is incorrect, please try again ");

			alert.showAndWait();
			}



		});

		btnCancel.setOnAction(event->{

			MainWindow main = new MainWindow();
			main.show();
			this.close();

		});

	}

	private void changeInformation() {
		list=list.getInstance();
		Persona s=list.changeInfo(coode);
		if(s!=null) {
			s.setName(tfChName.getText());

			s.setLastName(tfChLastName.getText());

			String gender = "";

			if (rdbChMale.selectedProperty().get() == true) {

				gender = rdbChMale.getText();
				s.setGender(gender);
			}

			else if (rdbChFem.selectedProperty().get() == true) {
				gender = rdbChFem.getText();
				s.setGender(gender);
			}

			String country = boxChNacionality.getPromptText();

			String birthDay = dateChBirthday.getValue().toString();

			String pathPhoto = "";

			String heithg = tfChHeight.getText();
			s.setHeith(heithg);

			int age = 2022 - (dateChBirthday.getValue().getYear());
			s.setAge(age);

			MainWindow main = new MainWindow();
			main.show();
			this.close();

		}
		else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("Invalid Password");
			alert.setContentText("Your Password is incorrect, please try again ");

			alert.showAndWait();

		}

	}


}
