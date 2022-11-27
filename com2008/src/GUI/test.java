package GUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class test {

	public static void main(String[] args) {
		int[] array1 = {1,1,1,2,8,6,1};
		int[] array2 = {2,4,6,1,4,18,61};
		int[] array3 = {2,8,18,2,1,1,8};
		
		List<List<Integer>> sortedOnes = new ArrayList<>();
		
		List<List<Integer>> finalList = new ArrayList<>();
		
		for(int i=0; i<array1.length; i++) {
			
			List<Integer> original = new ArrayList<>();
			original.add(array1[i]);
			original.add(array2[i]);
			original.add(array3[i]);
			
			List<Integer> sortForOne = new ArrayList<>();
			sortForOne.add(array1[i]);
			sortForOne.add(array2[i]);
			sortForOne.add(array3[i]);
			Collections.sort(sortForOne);
			
			
			if(!sortedOnes.contains(sortForOne)) {
				sortedOnes.add(sortForOne);
				finalList.add(original);
			}
			
		}
		
	
		System.out.print("a b c");
		for(int i=0; i<finalList.size(); i++) {
			System.out.println("");
			for(int j=0; j<finalList.get(i).size(); j++) {
				System.out.print(finalList.get(i).get(j)+" ");
			}
		}
	}
	
	

}
