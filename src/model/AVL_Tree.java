package model;


import java.util.Comparator;

public class AVL_Tree<T> {

	private Node root;

	private Node n;

	public void clearTree() {

		root = null;
	}

	public void add(String key, T value) {

		root = insert(root, key, value);
	}

	public int max(int a, int b) {

		return (a > b) ? a : b;
	}

	public int getFe(Node current) {

		if (current == null) {

			return 0;
		}

		return getAltura(current.getLeft()) - getAltura(current.getRight());

	}

	public String triggerSearch(String key) {

		Node n = search(root, key);

		String message = "";

		if (n == null) {

			message = n.getValue().toString();

		}

		return message;

	}

	public Node search(Node node, String key) {
		
		int aux = key.compareTo(node.getKey());
		
		if (node == null) {

			return null;

		}

		if (node.getKey().equalsIgnoreCase(key)) {

			return node;
		}

		/////////// procedimientos

		if (aux < 0) {

			return search(node.getLeft(), key);

		} else {

			return search(node.getRight(), key);
		}

	}

	public Node getMin(Node current) {

		if (current.getLeft() == null) {
			return current;
		} else {
			return getMin(current.getLeft());
		}
	}

	public Node getMax(Node current) {

		if (current.getRight() == null) {
			return current;
		} else {
			return getMin(current.getRight());
		}
	}

	public void triggerDelete(String key) {
		if (root != null) {
			root = delete(root, key);
		}

	}

	public Node delete(Node current, String key) {

		int aux = key.compareTo(current.getKey());
		
		if (current.getKey().equalsIgnoreCase(key)) {

			if (current.getLeft() == null && current.getRight() == null) {
				return null;
			} else if (current.getLeft() != null && current.getRight() != null) {

				Node sucess = getMin(current.getRight());

				Node newRightTree = delete(current.getRight(), sucess.getKey());

				sucess.setLeft(current.getLeft());
				sucess.setRight(newRightTree);

				return sucess;

			} else if (current.getLeft() != null) {

				return current.getLeft();

			} else {

				return current.getRight();
			}

		} else if (aux < 0) {

			Node newLeftTree = delete(current.getLeft(), key);
			current.setLeft(newLeftTree);

		} else {
			Node newRightTree = delete(current.getRight(), key);
			current.setRight(newRightTree);
		}

		if (current == null) {
			return current;
		}

		current.setHeight(1 + max(getAltura(current.getLeft()), getAltura(current.getRight())));

		int fe = getFe(current);

		// Rotacion simple a la derecha
		if (fe > 1 && getFe(current.getLeft()) >= 0) {
			return rightRotate(current);

		}

		// Rotacion simple a la izquierda
		if (fe < -1 && getFe(current.getRight()) <= 0) {
			return leftRotate(current);
		}

		// Rotacion doble izquierda derecha
		if (fe > 1 && getFe(current.getLeft()) < 0) {
			current.setLeft(leftRotate(current.getLeft()));
			return rightRotate(current);

		}

		// Rotacion doble derecha izquierda
		if (fe < -1 && getFe(current.getRight()) > 0) {

			current.setRight(rightRotate(current.getRight()));
			return leftRotate(current);

		}

		return current;
	}

	public void triggerShowTree() {

		System.out.println("///////////AVL///////////");
		showTree(root, 0);
	}

	public void showTree(Node nodo, int depth) {

		if (nodo.getRight() != null) {

			showTree(nodo.getRight(), depth + 1);
		}
		for (int i = 0; i < depth; i++) {
			System.out.print("	");
		}
		System.out.println("(" + nodo.getKey() + ")");

		if (nodo.getLeft() != null) {
			showTree(nodo.getLeft(), depth + 1);

		}

	}

	public Node insert(Node current, String key, T value) {
		
		int aux = key.compareTo(current.getKey());
		
		if (current == null) {
			return (new Node(key, value));
		}

		if (aux < 0) {

			current.setLeft(insert(current.getLeft(), key, value));

		} else if (aux > 0) {

			current.setRight(insert(current.getRight(), key, value));
		}

		else {

			return current;
		}

		// Actualizar la altura
		current.setHeight(1 + max(getAltura(current.getLeft()), getAltura(current.getRight())));

		int fe = getFe(current);

		// Rotacion simple a la derecha
		
		

		if (fe > 1 && (key.compareTo(current.getLeft().getKey())) < 0 ) {

			return rightRotate(current);

		}

		// Rotacion simple a la izquierda
		if (fe < -1 && (key.compareTo(current.getRight().getKey())) > 0) {

			return leftRotate(current);

		}

		// Rotacion doble izquierda derecha
		if (fe > 1 && (key.compareTo(current.getLeft().getKey())) > 0) {

			current.setLeft(leftRotate(current.getLeft()));
			return rightRotate(current);

		}

		// Rotacion doble derecha izquierda
		if (fe < -1 && (key.compareTo(current.getRight().getKey())) < 0 ) {

			current.setRight(rightRotate(current.getRight()));
			return leftRotate(current);

		}

		return current;

	}

	public Node rightRotate(Node current) {

		Node newRoot = current.getLeft();
		Node aux = newRoot.getRight();

		// Rotacion
		newRoot.setRight(current);
		current.setLeft(aux);

		// Actuliza alturas

		current.setHeight(max(getAltura(current.getLeft()), getAltura(current.getRight())) + 1);
		newRoot.setHeight(max(getAltura(newRoot.getLeft()), getAltura(newRoot.getRight())) + 1);

		return newRoot;

	}

	public Node leftRotate(Node current) {

		Node newRoot = current.getRight();
		Node aux = newRoot.getLeft();

		// Rotacion
		newRoot.setLeft(current);
		current.setRight(aux);

		// Actuliza alturas
		current.setHeight(max(getAltura(current.getLeft()), getAltura(current.getRight())) + 1);
		newRoot.setHeight(max(getAltura(newRoot.getLeft()), getAltura(newRoot.getRight())) + 1);

		return newRoot;

	}

	public int getAltura(Node current) {

		if (current == null) {
			return 0;
		}

		return current.getHeight();
	}

}
