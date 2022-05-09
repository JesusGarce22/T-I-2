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
	private Persona p;

	private TextField tfChName;
	private TextField tfChLastName;
	private TextField chPathPhoto;
	private TextField tfChHeight;

	private RadioButton rdbChMale;
	private RadioButton rdbChFem;

	private DatePicker dateChBirthday;

	private ImageView photo;

	private TextField tfChNacionality;

	private Button btnBrowse;
	private Button btnCancel;
	private Button btnUpload;

	private Persona p;
	
	public static AVL_Tree instance;
	public static PersonList list;

<<<<<<< HEAD
	public EditPerson(Persona p) {
		this.p=p;

=======
	public EditPerson(String coode) {
		this.coode=coode;
>>>>>>> 829c18aebc2728f42b9254c36b63ae16fed5b5ce
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EditPerson.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 600, 400);
			setScene(scene);

			tfChName = (TextField) loader.getNamespace().get("tfChName");
			tfChLastName = (TextField) loader.getNamespace().get("tfChLastName");
			chPathPhoto = (TextField) loader.getNamespace().get("chPathPhoto");
			tfChHeight = (TextField) loader.getNamespace().get("tfChHeight");
			tfChNacionality = (TextField) loader.getNamespace().get("tfChNacionality");

			rdbChMale = (RadioButton) loader.getNamespace().get("rdbChMale");
			rdbChFem = (RadioButton) loader.getNamespace().get("rdbChFem");

			photo = (ImageView) loader.getNamespace().get("photo");

			dateChBirthday = (DatePicker) loader.getNamespace().get("dateChBirthday");

			btnBrowse = (Button) loader.getNamespace().get("btnBrowse");
			btnUpload = (Button) loader.getNamespace().get("btnUpload");
			btnCancel = (Button) loader.getNamespace().get("btnCancel");

			instance=instance.getInstance();
			list = list.getInstance();
			 p=list.changeInfo(coode);
			   
			   tfChName.setText(p.getName().toString());
			   tfChLastName.setText(p.getLastName().toString());
			   tfChNacionality.setText(p.getCountry().toString());
			init();

		}catch(Exception ex) {
			ex.printStackTrace();

		}
	}

	public void init() {
		btnBrowse.setOnAction(event->{
			photoPath();
		});

		btnUpload.setOnAction(event->{
<<<<<<< HEAD

			if(p!=null){
=======
			String aux = instance.triggerSearch(coode);
		   Persona x= p;
		System.out.println("Persona antes de:"+x);
			if(x!=null){
>>>>>>> 829c18aebc2728f42b9254c36b63ae16fed5b5ce
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
			chPathPhoto.setText(file.getAbsolutePath());

		}
	}

	private void changeInformation() {
<<<<<<< HEAD
		list=list.getInstance();

		p.editPerson(p,tfChName.getText() ,tfChLastName.getText() , boxChNacionality.getPromptText(), 2022 - (dateChBirthday.getValue().getYear()), tfChHeight.getText(), "");
=======
		Persona s = p;
		if(s!=null) {
			s.setName(tfChName.getText());

			s.setLastName(tfChLastName.getText());
			
			String fullName = tfChName.getText()+" "+tfChLastName.getText();
			s.setFullName(fullName);
>>>>>>> 829c18aebc2728f42b9254c36b63ae16fed5b5ce

		String gender = "";

<<<<<<< HEAD
		if (rdbChMale.selectedProperty().get() == true) {
=======
			if (rdbChMale.selectedProperty().get() == true) {

				gender = rdbChMale.getText();
				s.setGender(gender);
			}

			else if (rdbChFem.selectedProperty().get() == true) {
				gender = rdbChFem.getText();
				s.setGender(gender);
			}

			String country = tfChNacionality.getText();
			s.setCountry(country);
			String birthDay = dateChBirthday.getValue().toString();
			s.setBirthDay(birthDay);
			String pathPhoto = "";

			String heithg = tfChHeight.getText();
			s.setHeith(heithg);

			int age = 2022 - (dateChBirthday.getValue().getYear());
			s.setAge(age);

			MainWindow main = new MainWindow();
			main.show();
			this.close();
>>>>>>> 829c18aebc2728f42b9254c36b63ae16fed5b5ce

			gender = rdbChMale.getText();
		}

		else if (rdbChFem.selectedProperty().get() == true) {
			gender = rdbChFem.getText();
		}
<<<<<<< HEAD

		String pathPhoto = "";

		MainWindow main = new MainWindow();
		main.show();
		this.close();

	}


}



=======
		s = p;
	}
	
}
>>>>>>> 829c18aebc2728f42b9254c36b63ae16fed5b5ce
