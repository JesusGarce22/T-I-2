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

public class AddPerson extends Stage {
	
    
    private RadioButton rdbMale;
    private RadioButton rdbFem;
    
    private ImageView photo;
    
    private TextField tfName;
    private TextField tfLastName;
    private TextField pathFhoto;
    private TextField tfHeight;

    private DatePicker dateBirthday;
    
    private Button btnBrowse;
    private Button btnUpload;
    private Button btnCancel;
  
    private ComboBox<String> boxNacionality;
	
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
		
		rdbMale = (RadioButton) loader.getNamespace().get("rdbMale");
		rdbFem = (RadioButton) loader.getNamespace().get("rdbFem");
		
		photo = (ImageView) loader.getNamespace().get("photo");
		
		dateBirthday = (DatePicker) loader.getNamespace().get("dateBirthday");
		
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
