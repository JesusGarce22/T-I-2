package ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class EditPerson extends Stage {
	
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
	
	public EditPerson() {
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EditPerson.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			tfChName = (TextField) loader.getNamespace().get("tfChName");
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
			
			init();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
	}

	public void init() {
		
		btnBrowse.setOnAction(event->{
			
			
		});
		
		btnUpload.setOnAction(event->{
			
			
		});
		
		btnCancel.setOnAction(event->{
			
			MainWindow main = new MainWindow();
			main.show();
			this.close();
			
		});
		
	}

}
