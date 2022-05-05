package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.PersonList;
import model.Persona;

public class Edit extends Stage{

    private TextField codeChange;
    public static PersonList list;

    private Button OK;
    
	public Edit() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Edit.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 300, 200);
			setScene(scene);
			
			OK = (Button) loader.getNamespace().get("OK");
			codeChange = (TextField) loader.getNamespace().get("codeChange");
			list=list.getInstance();
			
			init();
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
	}
	
	private void init() {
		OK.setOnAction(event->{
			
			if(codeChange.getText()!=null) {
				EditPerson edit = new EditPerson(codeChange.getText());
				edit.show();
				this.close();
			}
			
		});
		
	}

}
