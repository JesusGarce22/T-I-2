package model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import ui.GenerateDates;
import ui.Main;

public class Leer extends Thread{

	private int number;
	public static AVL_Tree instance;
	public static PersonList list;
	public static Save lod;

	public Leer(int number) {
		this.number=number;
		instance=AVL_Tree.getInstance();
		list=list.getInstance();
		lod = Save.getInstance();
	}

	@Override
	public void run() {

		generateDates(number);
	}

	public static ArrayList<String> readNames() {
		//names
		ArrayList<String> name = new ArrayList<>();// Almacena los nombres importados de la base de datos
		try {
			//leer archivo .csv
			File file= new File("datasets\\names.csv");

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

	public static ArrayList<String> readLastNames() {
		//Apellidos
		ArrayList<String> lastname = new ArrayList<>();// Almacena los apellidos importados de la base de datos
		try {
			//leer archivo .csv
			File file= new File("datasets\\apellidos.csv");

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

	public static ArrayList<String> readGender(){
		ArrayList<String> gender = new ArrayList<>();// Almacena los nombres importados de la base de datos
		try {
			//leer archivo .csv
			File file= new File("datasets\\names.csv");

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

			//Agregar solo los nombres a la base de datos
			for(int i=1; i<parts.length;i+=5) {
				gender.add(parts[i]);
			}

			/* imprimir los primeros 20 nombres
			for(int i=0; i<20;i++) {
				System.out.println("--"+gender.get(i)+"---");
			}*/
			return gender;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;

	}

	public static ArrayList<String> readCountris() {
		//paises
		ArrayList<String> pais = new ArrayList<>();// Almacena los paises importados de la base de datos
		try {
			//leer archivo .csv
			File file= new File("datasets\\pais.csv");

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

	public static String autoGenerateGender(ArrayList<String> gender) {
		int indiceAleatorio = numeroAleatorioEnRango(0, gender.size() - 1);
		String RandomLastname = gender.get(indiceAleatorio);
		return RandomLastname;
	}

	public static String autoGenerateLastnames(ArrayList<String> lastnames) {
		int indiceAleatorio = numeroAleatorioEnRango(0, lastnames.size() - 1);
		String RandomLastname = lastnames.get(indiceAleatorio);
		return RandomLastname;
	}

	public static String autoGeneraNames(ArrayList<String> name) {
		int indiceAleatorio = numeroAleatorioEnRango(0, name.size() - 1);
		String RandomName = name.get(indiceAleatorio);
		return RandomName;
	}

	public static String autoGenerateCountris(ArrayList<String> pais) {
		int indiceAleatorio = numeroAleatorioEnRango(0, pais.size() - 1);
		String RandomCountri = pais.get(indiceAleatorio);
		return RandomCountri;
	}

	public static String autoCode(ArrayList<String> code) {
		int indiceAleatorio = numeroAleatorioEnRango(0, code.size() - 1);
		String RandomCountri = code.get(indiceAleatorio);
		return RandomCountri;
	}

	public static String autoMonth(ArrayList<String> month) {
		int indiceAleatorio = numeroAleatorioEnRango(0, month.size() - 1);
		String RandomCountri = month.get(indiceAleatorio);
		return RandomCountri;
	}

	public static int numeroAleatorioEnRango(int minimo, int maximo) {
		// nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
		return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
	}

	public static String generatecode(String message,int contador) {
		ArrayList<String> code = new ArrayList<>();
		code.add("A");
		code.add("u");
		code.add("E");
		code.add("J");
		code.add("K");
		code.add("L");

		int j=(int) (Math.random() * 50 + 1);

		message+=j;
		message+=autoCode(code);

		contador++;

		if(contador==4) {
			return message;
		}else {
			return generatecode(message,contador);	
		}

	}

	public static String generateHeigth(String st) {
		if(st.equalsIgnoreCase("girl")) {
			int minimo=50;
			int maximo=80;

			String heigth="1."+ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
		}

		int minimo=60;
		int maximo=99;

		String heigth="1."+ThreadLocalRandom.current().nextInt(minimo, maximo + 1);

		return heigth;
	}

	public static String generateDateOfBirtday(int age) {
		ArrayList<String> dateB = new ArrayList<>();
		dateB.add("JANUARY");
		dateB.add("FEBRUARY");
		dateB.add("MARCH");
		dateB.add("APRIL");
		dateB.add("MAY");
		dateB.add("JUNE");
		dateB.add("JULY");
		dateB.add("AUGUST");
		dateB.add("SEPTEMBER");
		dateB.add("OCTOBER");
		dateB.add("NOVEMBER");
		dateB.add("DECEMBER");

		String date=(int) (Math.random() * 30 + 1)+" "+autoMonth(dateB)+" "+(2022-age);
		return date;
	}

	public static void generateDates(int num) {

		if(num<=0) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERROR");
			alert.setHeaderText("NUMERO NO VALIDO");
			alert.setContentText("El numero que ingresaste no es valido, por favor ingresa un numero mayor a 0");

			alert.showAndWait();
		}else {
			ArrayList<String> name=readNames();
			ArrayList<String> lastname=readLastNames();
			ArrayList<String> country=readCountris();
			ArrayList<String> gender=readGender();
			for(int i =0;i<num;i++) {
				String x="";
				int contador=0;
				Persona p=new Persona(autoGeneraNames(name), autoGenerateLastnames(lastname), "",autoGenerateCountris(country),"", generatecode(x,contador), autoGenerateGender(gender),(int) (Math.random() * 80 + 1),"");
				String d=generateDateOfBirtday((int) p.getAge());
				p.setBirthDay(d);
				String h=generateHeigth((String) p.getGender());
				p.setHeith(h);
				
				instance.add(p.getCode().toString(), p);
				list.add(p);
				lod.saveReadableFile(p);
				
				p.printInfo();
				instance.triggerShowTree();
				//instance.triggerShowTree();

			}
		}
	}
}
