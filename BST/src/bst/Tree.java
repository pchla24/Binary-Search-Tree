package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
	
	public void insert(int id) {
		
		Node newNode = new Node(); 
		newNode.iData = id; 
		
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
	
	public void insertArr(int[] a) {
		for(int i=0; i<a.length; i++)
			this.insert(a[i]);
	}
	
	
	private void inOrder(Node localRoot) {
		
		if(localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}
	
	public boolean doBreadthFirstSearch(int id) {
		
		if(root.iData == id) {
            System.out.println("Znaleziony - korzeñ");
            return true;
        }
		
		Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> explored = new ArrayList<>();
        queue.add(root);
        explored.add(root);
        
        while(!queue.isEmpty() ){
            Node current = queue.remove();
            if(current.iData == id) {
                return true;
            }
            else {
                if(current.getChildren().isEmpty()) {
                	
                }
                    
                else
                    queue.addAll(current.getChildren());
            }
            explored.add(current);
        }

        return false;
	}

}
