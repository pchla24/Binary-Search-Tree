package bst;

import java.util.ArrayList;

public class Node {

	int iData; 
	
	Node leftChild;
	Node rightChild; 
	
	public void displayNode() {
		System.out.print("{");
		System.out.print(iData);
		System.out.print("} ");
	}
	
	public ArrayList<Node> getChildren(){
        ArrayList<Node> childNodes = new ArrayList<>();
        if(this.leftChild != null)
        {
            childNodes.add(leftChild);
        }
        if(this.rightChild != null) {
            childNodes.add(rightChild);
        }
        return childNodes;
    }
	
}
