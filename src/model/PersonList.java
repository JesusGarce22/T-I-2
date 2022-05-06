package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PersonList {

	private ArrayList<Persona> list;
	private static PersonList instance;

	public static PersonList getInstance() {
		if (instance == null) {
			instance = new PersonList();
			;
		}

		return instance;
	}

	private PersonList() {

		setList(new ArrayList<Persona>());

	}

	public ArrayList<Persona> getList() {
		return list;
	}

	public void setList(ArrayList<Persona> list) {
		this.list = list;
	}

	public boolean searchUser(String id) {
		boolean find = true;  

		for(int i = 0;i < list.size();i++) {
			if(list.get(i).getName().toString().equalsIgnoreCase(id)) {
				find = false;
			}
		}
		return find;
	}

	
	public Persona changeInfo(String code) {
		Persona find = new Persona("", "", "","", "", "","", "", "");  

		for(int i = 0;i < list.size();i++) {
			if(list.get(i).getCode().toString().equalsIgnoreCase(code)) {
				find = list.get(i);
			}
		}
		return find;
	}

	public void add(Persona p) {
		list.add(p);
	}

	public void ornedar() {
		Comparator<Persona> comparadorA =(o1,o2)->{
			return o1.getName().toString().compareToIgnoreCase(o2.getName().toString());
	
		};
		
		Collections.sort(getList(), comparadorA);
	}

	public void removeList() {
		list.removeAll(list);
		
		
	}
	
}
