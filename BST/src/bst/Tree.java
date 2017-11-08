package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree {

	public Node root; 
	
	public Tree() {
		root = null;
	}
	
	public Node find(int id) {
		
		Node current = root;
		while(current.iData != id) {
			if(id < current.iData) 
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
	
	
	public void inOrder(Node localRoot) {
		
		if(localRoot != null) {
			inOrder(localRoot.leftChild);
			System.out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}
	
	public void preOrder(Node localRoot) {
		
		if(localRoot != null) {
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	public void postOrder(Node localRoot) {
		
		if(localRoot != null) {
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			System.out.print(localRoot.iData + " ");
		}
	}
	
	public Node doBreadthFirstSearch(int id) {
		
		if(root.iData == id) 
			return root;
		
		Queue<Node> queue = new LinkedList<>();
		ArrayList<Node> explored = new ArrayList<>();
		queue.add(root);
		explored.add(root);
        
		while(!queue.isEmpty() ){
			Node current = queue.remove();
			if(current.iData == id) {
				return current;
			}
			else {
				if(current.getChildren().isEmpty()) {
                	;
				}
                    
				else
					queue.addAll(current.getChildren());
			}
			explored.add(current);
		}

		return null;
	}
	
	public Node doDepthFirstSearch(int id) {
		
		if(root.iData == id) 
			return root;
		
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			Node current = stack.pop();
			if(current.iData == id)
				return current;
			else {
				if(current.rightChild != null)
					stack.push(current.rightChild);
				if(current.leftChild != null)
					stack.push(current.leftChild);
			}
		}
		
		return null;
	
	}
	
}
