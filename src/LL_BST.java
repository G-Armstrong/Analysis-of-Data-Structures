import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LL_BST {
	public static void main(String[] args) {
		//Testing BST and LinkedList
				
			LinkedList<String> animalLL = new LinkedList<>();
			BST<String> animalBST = new BST<>();
			
			ArrayList<String> list = new ArrayList<>();
			File file = new File("animals.txt");
			Scanner readFile = null;
			try {
				readFile = new Scanner(file);
			}
			catch(FileNotFoundException e) {
				System.out.println("File not found.");
				System.exit(0);
			}
			while(readFile.hasNext()) {
				String name = readFile.nextLine();
				list.add(name);
			}
			readFile.close();
			//Unsorted list
			for(String name: list) {
				animalLL.add(name);
				animalBST.insert(name);
			}
			
			Random r = new Random();
			
			System.out.println("Comparing search operations on LinkedList and BST using a shuffled list\n");
			int sum1=0,sum2 =0;
			System.out.printf("%-11s\t\t\t%-20s\t%-20s\n", "Animal name", "Iterations (LL)", "Iterations (BST)");
			for(int i=0;i<10;i++) {
				int randomIndex = r.nextInt(list.size());
				String randomName = list.get(randomIndex);
				int LLIter = animalLL.searchIterations(randomName);
				int BSTIter = animalBST.searchIterations(randomName);
				
				sum1 += LLIter;
				sum2 += BSTIter;
					
				System.out.printf("%-30s\t%-20d\t%-20d\n",randomName,LLIter, BSTIter);
				
			}
			System.out.println("Average # of iterations: " + "\t" + (sum1 / 10) + "\t\t\t" + (sum2 / 10) + "\n\n");
			
			animalLL.clear();
			animalBST.clear();
			java.util.Collections.sort(list);
			for(String name: list) {
				animalLL.add(name);
				animalBST.insert(name);
			}
			
		
			
			System.out.println("Comparing search operations on LinkedList and BST using a sorted list\n");
			int sum3=0,sum4 =0;
			System.out.printf("%-11s\t\t\t%-20s\t%-20s\n", "Animal name", "Iterations (LL)", "Iterations (BST)");
			for(int i=0;i<10;i++) {
				int randomIndex = r.nextInt(list.size());
				String randomName = list.get(randomIndex);
				int LLIter = animalLL.searchIterations(randomName);
				int BSTIter = animalBST.searchIterations(randomName);
				
				sum3 += LLIter;
				sum4 += BSTIter;
					
				System.out.printf("%-30s\t%-20d\t%-20d\n",randomName,LLIter, BSTIter);
				
			}
			System.out.println("Average # of iterations: " + "\t" + (sum3 / 10) + "\t\t\t" + (sum4 / 10));
/**
 * Discussion
 * When an unsorted list is used, the iterations for BST are markedly lower than those of the Linked List. When the data is sorted the inserted into the BST, the BST
 * looks more like a LinkedList with all its members in ascending or descending linear order. To iterate through the sorted BST, it must go through a comparably 
 * long path to that of the LinkedList. 
 * 
 * When the BST and LinkeLists are unsorted, the LinkedList shows variation in the iterations per search term, but overall, the average iterations is much higher for the
 * LinkedList than for the unsorted BST. This is because an unsorted BST contains within its structural hierarchy (or branches) the means to more quickly arrive
 * at the desired item. For instance, entire left and right branches of data can be eliminated quickly from consideration based on simple comparison (compareTo). 
 * A linked list, however, still requires each term to be looked through linearly until the desired item is found. 
 */
	}
}
