package model;

public class Node<T> {

	private int height;
	private String key;
	private T value;

	private Node left;
	private Node right;

	public AVL_Tree t;

	public Node(String key, T value) {

		this.height = 1;
		this.key = key;
		this.value = value;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}