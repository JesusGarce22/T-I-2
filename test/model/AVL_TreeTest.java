package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AVL_TreeTest {

	private AVL_Tree arbol;

	public void setupScenary1() {
		arbol = new AVL_Tree();
	}

	public void setupScenary2() {
		arbol = new AVL_Tree();

		Persona p=new Persona("jesus", "garces", "2 marzo 2002", "Colombia", "xxxxx", "A00HDY3BF", "BOY", "20", "1.73");

		arbol.add(p.getCode().toString(), p);
	}
	
	public void setupScenary3() {
		arbol = new AVL_Tree();

		Persona p=new Persona("andres", "perez", "25 diciembre 1993", "BRASIL", "xxxxx", "A7SD76DA5SG", "BOY", "29", "1.79");

		arbol.add(p.getCode().toString(), p);
	}
	
	public void setupScenary4() {
		arbol = new AVL_Tree();

		Persona p=new Persona("andres", "perez", "25 diciembre 1993", "BRASIL", "xxxxx", "A7SD76DA5SG", "BOY", "29", "1.79");
		Persona f=new Persona("andres", "perez", "25 diciembre 1993", "BRASIL", "xxxxx", "A7SD76DA5SG", "BOY", "29", "1.79");
		Persona t=new Persona("jesus", "garces", "2 marzo 2002", "Colombia", "xxxxx", "A00HDY3BF", "BOY", "20", "1.73");

		
		arbol.add(p.getCode().toString(), p);
		arbol.add(f.getCode().toString(), f);
		arbol.add(t.getCode().toString(), t);
	}

	@Test
	void InsertTest() {
		setupScenary2();

		Node x=arbol.getTree();
		
		assertNotNull(x);
	}
	
	@Test
	public void searchTest() {
		setupScenary1();
		
		Persona p=new Persona("carlos", "hernadez", "21 abril 2012", "Colombia", "xxxxx", "AFA7A6S67AD", "BOY", "24", "1.30");
		arbol.add(p.getCode().toString(), p);
		
		String a=arbol.triggerSearch(p.getCode().toString());

		assertEquals(a, arbol.getTree().getValue().toString());

	}
	
	@Test
	public void clearTest() {
		setupScenary3();
		
		arbol.clearTree();
		Node root=arbol.getTree();
		assertEquals(root,null);
	}

	@Test
	public void deleteTest() {
		setupScenary1();
		
		Persona p=new Persona("carlos", "hernadez", "21 abril 2012", "Colombia", "xxxxx", "AFA7A6S67AD", "BOY", "24", "1.30");
		arbol.add(p.getCode().toString(), p);
		Persona r=new Persona("jesus", "garces", "2 marzo 2002", "Colombia", "xxxxx", "A00HDY3BF", "BOY", "20", "1.73");
		arbol.add(r.getCode().toString(), r);
		
		arbol.triggerDelete(r.getCode().toString());
		
		Node root=arbol.getTree();
		assertEquals(root.getValue().toString(), p.toString());
	}
	
	@Test
	public void alturaTest() {
		setupScenary4();
		
		Node root=arbol.getTree();
		int x=arbol.getAltura(root);
		
		assertEquals(2, x);
	}
}
