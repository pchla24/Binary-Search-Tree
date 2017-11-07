package bst;

import java.util.Random;

public class MainTree {
	
	private static int getRand(int min, int max) {
		
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

	public static void main(String[] args) {
		
		Tree theTree = new Tree(); 
		
		int size = getRand(1, 100);
		int[] arr = new int[size];
		
		for(int i=0; i<size; i++)
			arr[i] = getRand(1, 100);
		
		theTree.insertArr(arr);

		int id = 25;
		
		Node found = theTree.find(id);							//szukanie optymalne
		boolean foundBool = theTree.doBreadthFirstSearch(id);	//szukanie wszerz
		
		if(found != null) {
			System.out.println("Znalaz³em wêze³ o id = 25");
		}
		else
			System.out.println("Nie znalaz³em wêz³¹ o id = 25");
		
		if(foundBool)
			System.out.println("Znalaz³em wêze³ o id = " + id);
		else 
			System.out.println("Nie znalaz³em wêz³a o id = " + id);
	} 

}


