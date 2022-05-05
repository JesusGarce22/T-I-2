package ui;

import java.io.IOException;
import java.util.Optional;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.AVL_Tree;
import model.PersonList;
import model.Persona;

public class MainWindow extends Stage {

	private TextField tfSearch;
	public static BaseOfDates list;
	public static AVL_Tree instance;

	private ListView<Persona> listUsers;
	private Button btnAdd;
	private Button btnEdit;
	private Button btnDelete;
	private Button btnAuto;
	private Button btnSearch;
	private Button showTable;
	private Button btnDeletaBD;

	public MainWindow() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 600, 400);
			setScene(scene);
			
			instance=AVL_Tree.getInstance();
	

			btnSearch = (Button) loader.getNamespace().get("btnSearch");
			tfSearch = (TextField) loader.getNamespace().get("tfSearch");
			listUsers = (ListView) loader.getNamespace().get("listUsers");
			btnAdd = (Button) loader.getNamespace().get("btnAdd");
			btnEdit = (Button) loader.getNamespace().get("btnEdit");
			btnDelete = (Button) loader.getNamespace().get("btnDelete");
			btnAuto = (Button) loader.getNamespace().get("btnAuto");
			showTable = (Button) loader.getNamespace().get("showTable");
			btnDeletaBD = (Button) loader.getNamespace().get("btnDeletaBD");
			init();


		}catch(Exception ex) {

			ex.printStackTrace();
		}

	}


	public void init() {

		btnAdd.setOnAction(event -> {

			AddPerson add = new AddPerson();
			add.show();
			this.close();
		});

		btnEdit.setOnAction(event ->{

				Edit e=new Edit();
				e.show();
		});

		btnSearch.setOnAction(event ->{


		});

		btnDelete.setOnAction(event ->{


		});

		btnAuto.setOnAction(event ->{

			GenerateDates g=new GenerateDates();
			g.show();
			this.close();

		});

		showTable.setOnAction(event ->{
			list=list.getInstance();
			list.show();

		});
		
		btnDeletaBD.setOnAction(event ->{
			
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("ALERTA");
			alert.setHeaderText("Eliminacion de base de datos");
			alert.setContentText("Seguro que dese eliminar la base de datos?");
			
			Optional<ButtonType> result = alert.showAndWait();
			
			if(result.get()== ButtonType.OK) {
				instance.clearTree();
				list.deleteList();
			}
		});
		
	}

}
