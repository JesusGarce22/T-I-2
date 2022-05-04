package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.PersonList;
import model.Persona;

public class BaseOfDates extends Stage{

	public static BaseOfDates instance;
	public static PersonList list;
	static ObservableList<Persona> observableList;

	private TableColumn<Persona, String> codeC;
	private TableColumn<Persona, String> lastnNameC;
	private TableColumn<Persona, String> conuntryC;
	private TableColumn<Persona, String> nameC;
	private TableColumn<Persona, String> staC;
	private TableColumn<Persona, String> agaC;
	private TableColumn<Persona, String> dateC;
	private TableColumn<Persona, String> genderC;
	private TableView<Persona> table;

	public BaseOfDates() {
		list=list.getInstance();

		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("BaseOfDates.fxml"));
			Parent root;
			root = loader.load();

			Scene scene = new Scene(root, 717, 443);
			setScene(scene);

			table = (TableView) loader.getNamespace().get("table");
			genderC = (TableColumn) loader.getNamespace().get("genderC");
			agaC = (TableColumn) loader.getNamespace().get("agaC");
			nameC = (TableColumn) loader.getNamespace().get("nameC");
			dateC = (TableColumn) loader.getNamespace().get("dateC");
			lastnNameC = (TableColumn) loader.getNamespace().get("lastnNameC");
			staC = (TableColumn) loader.getNamespace().get("staC");
			codeC = (TableColumn) loader.getNamespace().get("codeC");
			conuntryC = (TableColumn) loader.getNamespace().get("conuntryC");

			table();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void table() {

		observableList = FXCollections.observableArrayList(list.getList());

		table.setItems(observableList);

		//T name, T lastName, T birthDay, T country, T photo, T code,T gender,T age,T heith
		//Enlaces con elementos de la tabla
		nameC.setCellValueFactory(new PropertyValueFactory<Persona, String>("name"));
		codeC.setCellValueFactory(new PropertyValueFactory<Persona, String>("code"));
		dateC.setCellValueFactory(new PropertyValueFactory<Persona, String>("birthDay"));
		lastnNameC.setCellValueFactory(new PropertyValueFactory<Persona, String>("lastName"));
		conuntryC.setCellValueFactory(new PropertyValueFactory<Persona, String>("country"));
		agaC.setCellValueFactory(new PropertyValueFactory<Persona, String>("age"));
		genderC.setCellValueFactory(new PropertyValueFactory<Persona, String>("gender"));
		staC.setCellValueFactory(new PropertyValueFactory<Persona, String>("heith"));
	}
	
	public static BaseOfDates getInstance() {
		if (instance == null) {
			instance = new BaseOfDates();
			;
		}

		return instance;
	}
	
	public void deleteList() {
		observableList=null;
		
		table.setItems(observableList);
	}
}
