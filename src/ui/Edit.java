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
import model.AVL_Tree;
import model.Node;
import model.PersonList;
import model.Persona;

public class Edit extends Stage{

    private TextField codeChange;
    public static AVL_Tree istance;

    private Button OK;
    
	public Edit() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Edit.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 300, 200);
			setScene(scene);
			
			OK = (Button) loader.getNamespace().get("OK");
			codeChange = (TextField) loader.getNamespace().get("codeChange");
			istance=istance.getInstance();
			
			init();
		}catch(Exception ex) {
			ex.printStackTrace();
			
		}
	}
	
	private void init() {
		OK.setOnAction(event->{
			String code=istance.triggerSearch(codeChange.getText());
			Node x=istance.nodeForEdit(null);
			if(code.equalsIgnoreCase(x.getValue().toString())) {
				EditPerson edit = new EditPerson((Persona) x.getValue());
				edit.show();
				this.close();
			}
			
		});
		
	}

}