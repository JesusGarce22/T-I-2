package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ImportarTest {

	private Leer theard;
	private PersonList instance;
	
	public void setupScenary2() {
		instance=instance.getInstance();

	}
	
	@Test
	void GenerateTest() {
		//MIRAR CONSOLA
		//NO FUNCIONO :C
		setupScenary2();
		
		theard = new Leer(5);;
		theard.start();
		
		assertEquals(instance.getList().size(), 0);
	}

}
