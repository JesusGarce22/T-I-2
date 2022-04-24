package model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Leer {

	public ArrayList<String> readNames() {
		//names
		ArrayList<String> name = new ArrayList<>();// Almacena los nombres importados de la base de datos
		try {
			//leer archivo .csv
			File file= new File("D:\\Jesus\\proyectos\\T-I-2\\datasets\\names.csv");

			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			byte[] buffer = new byte[30000];
			int bytesQuePudeLeer = 0;

			while ((bytesQuePudeLeer = fis.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesQuePudeLeer);
			}
			fis.close();
			baos.close();

			String lectura = baos.toString();
			String parts[] = lectura.split(";");

			//Agregar solo los nombres a la base de datos
			for(int i=0; i<parts.length;i+=5) {
				name.add(parts[i]);
			}

			/* imprimir los primeros 20 nombres
			for(int i=0; i<20;i++) {
				System.out.print(name.get(i));
			}*/
			return name;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> readLastNames() {
		//Apellidos
		ArrayList<String> lastname = new ArrayList<>();// Almacena los apellidos importados de la base de datos
		try {
			//leer archivo .csv
			File file= new File("D:\\Jesus\\proyectos\\T-I-2\\datasets\\apellidos.csv");

			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			byte[] buffer = new byte[300000];
			int bytesQuePudeLeer = 0;

			while ((bytesQuePudeLeer = fis.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesQuePudeLeer);
			}
			fis.close();
			baos.close();

			String lectura = baos.toString();
			String parts[] = lectura.split(";");

			//Agregar solo los apellidos a la base de datos
			for(int i=12; i<parts.length;i+=12) {
				lastname.add(parts[i]);
			}

			/* imprimir los primeros 20 apellidos
			for(int i=0; i<20;i++) {
				System.out.println( "--"+lastname.get(i)+ "--");
			}*/
			return lastname;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public ArrayList<String> readCountris() {
		//paises
		ArrayList<String> pais = new ArrayList<>();// Almacena los paises importados de la base de datos
		try {
			//leer archivo .csv
			File file= new File("D:\\Jesus\\proyectos\\T-I-2\\datasets\\pais.csv");

			FileInputStream fis = new FileInputStream(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			byte[] buffer = new byte[30000];
			int bytesQuePudeLeer = 0;

			while ((bytesQuePudeLeer = fis.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesQuePudeLeer);
			}
			fis.close();
			baos.close();

			String lectura = baos.toString();
			String parts[] = lectura.split(";");

			//Agregar solo los paises a la base de datos
			for(int i=2; i<parts.length;i+=2) {
				pais.add(parts[i]);
			}

			/* imprimir los primeros 20 paises
			for(int i=0; i<20;i++) {
				System.out.println(pais.get(i));
			}*/
			return pais;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
