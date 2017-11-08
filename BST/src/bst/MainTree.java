package bst;

import java.util.Random;

public class MainTree {
	
	private static int getRand(int min, int max) {
		
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public static void main(String[] args) {
		
		Tree theTree = new Tree(); 
		
		int minSize = 1;
		int maxSize = 25;
		
		int size = getRand(minSize, maxSize);
		int[] arr = new int[size];
		
		for(int i=0; i<size; i++)
			arr[i] = getRand(1, 25);
		
		theTree.insertArr(arr);

		int id = 10;
		
		Node found = theTree.find(id);									// szukanie binarne
		Node foundBFS = theTree.doBreadthFirstSearch(id);				// szukanie wszerz
		Node foundDFS = theTree.doDepthFirstSearch(id);					// szukanie wg��b
		
		if(found != null)
			System.out.println("Binary: Znalaz�em w�ze� o id = " + id);
		else
			System.out.println("Binary: Nie znalaz�em w�z�a o id = " + id);
		
		if(foundBFS != null)
			System.out.println("BFS: Znalaz�em w�ze� o id = " + id);
		else 
			System.out.println("BFS: Nie znalaz�em w�z�a o id = " + id);
		
		if(foundDFS != null)
			System.out.println("DFS: Znalaz�em w�ze� o id = " + id);
		else 
			System.out.println("DFS: Nie znalaz�em w�z�a o id = " + id);
		
		System.out.println("Trawersowanie InOrder:");
		theTree.inOrder(theTree.root);
		System.out.println("\nTrawersowanie PreOrder:");
		theTree.preOrder(theTree.root);
		System.out.println("\nTrawersowanie PostOrder:");
		theTree.postOrder(theTree.root);
		
	} 

}


