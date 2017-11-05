package bst;

public class Tree {

	private Node root; 
	
	public Tree() {
		root = null;
	}
	
	public Node find(int key) {
		
		Node current = root;
		while(current.iData != key) {
			if(key < current.iData) 
				current = current.leftChild;
			else
				current = current.rightChild; 
			if(current == null) 
				return null; 
		}
		
		return current; 
	}
	
	public void insert(int id, double dd) {
		
		Node newNode = new Node(); 
		newNode.iData = id; 
		newNode.fData = dd;
		
		if(root==null) 
			root = newNode;
		else {
			Node current = root; 
			Node parent;
			while(true) {
				parent = current;
				if(id < current.iData) {
					current = current.leftChild;
					if(current == null) { 
						parent.leftChild = newNode;
						return;
					}
				} 
				else {
					current = current.rightChild;
					if(current == null) { 
						parent.rightChild = newNode;
						return;
					}
					
				}
			}
		}
	}
	
	public void delete(int key) {
		
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(current.iData != key) {
			parent = current;
			if(key < current.iData) {
				isLeftChild = true;
				current = current.leftChild;
			}
			else {
				isLeftChild = false;
				current = current.rightChild;

			}
			if(current == null) 
				return;
		}
		
		if(current.leftChild == null && current.rightChild == null) {	// bez potomków
			if(current == root) 
				root = null;
			else if(isLeftChild)
				parent.leftChild = null; 
			else
				parent.rightChild = null;
		}
		
		else if(current.rightChild == null)			// brak prawego potomka
			if(current == root)
				root = current.leftChild;
			else if(isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		
		else if(current.leftChild == null)			// brak lewego potomka
			if(current == root)
				root = current.rightChild;
			else if(isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.rightChild;
		
	}
	
	
	private void inOrder(Node localRoot) {
		
		if(localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}
	
	public Node minimum() {
		Node current, last = null;
		current = root; 
		while(current != null) {
			last = current; 
			current = current.leftChild;
		}
		return last;
	}
	
	public Node maximum() {
		Node current, last = null;
		current = root; 
		while(current != null) {
			last = current; 
			current = current.rightChild;
		}
		return last;
	}
	
}
