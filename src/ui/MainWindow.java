package ui;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Persona;

public class MainWindow extends Stage {

	private TextField tfSearch;
	public static BaseOfDates list;

	private ListView<Persona> listUsers;
	private Button btnAdd;
	private Button btnEdit;
	private Button btnDelete;
	private Button btnAuto;
	private Button btnSearch;
	private Button showTable;

	public MainWindow() {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
			Parent root = loader.load();

			Scene scene = new Scene(root, 600, 400);
			setScene(scene);

			btnSearch = (Button) loader.getNamespace().get("btnSearch");
			tfSearch = (TextField) loader.getNamespace().get("tfSearch");
			listUsers = (ListView) loader.getNamespace().get("listUsers");
			btnAdd = (Button) loader.getNamespace().get("btnAdd");
			btnEdit = (Button) loader.getNamespace().get("btnEdit");
			btnDelete = (Button) loader.getNamespace().get("btnDelete");
			btnAuto = (Button) loader.getNamespace().get("btnAuto");
			showTable = (Button) loader.getNamespace().get("showTable");

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

			EditPerson edit = new EditPerson();
			edit.show();
			this.close();

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



	}


}
