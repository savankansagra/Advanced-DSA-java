package searchingandsorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuketSortStudent {
	int swapCount = 0;

	private void swap(List<Faculty> ft, int i, int j) {
		if (ft != null) {
			Faculty temp = ft.get(i);
			ft.set(i, ft.get(j));
			ft.set(j, temp);
			swapCount++;
		}
	}	
	
	
	private int[] hash(Faculty[] input) {
		Faculty m=input[0];
		for (int i = 0; i < input.length; i++) {
			if(m.faculty_ID < input[i].faculty_ID) {
				m = input[i];
			}
		}
		return new int[] {m.faculty_ID, (int) Math.sqrt(input.length)};
	}
	
	private int hash(int i, int[] code) {
		return (int)(((double)i / code[0]) * (code[1] -1));
	}
	
	
	private void bucketSort(Faculty[] ft) {
		if(ft == null && ft.length <=0) {
			return;
		}
		
		//get the how much size require for bucket.
		final int[] code  = hash(ft);
		
		@SuppressWarnings("unchecked")
		List<Faculty>[] bucket = new ArrayList[code[1]];
		
		//create empty buckets
		for(int i=0;i<code[1];i++) {
			bucket[i] = new ArrayList<Faculty>();
		}
		
		// Add elements into the buckets
		for(int i=0;i<ft.length;i++) {
			int bucketIndex = hash(ft[i].faculty_ID, code);
			bucket[bucketIndex].add(ft[i]);
		}
		
		//sort the elements of each bucket
		for(int i=0; i<code[1]; i++) {
			for(int j=0;j<bucket[i].size();j++) {
				for(int k=j+1;k<bucket[i].size();k++) {
					if(bucket[i].get(j).faculty_ID > bucket[i].get(k).faculty_ID) {
						//swap it.
						swap(bucket[i], i, j);
					}
				}
			}
		}
		
		// Get the sorted array.
		int index=0;
		for(int i=0;i<code[1];i++) {
			for(int j=0, size = bucket[i].size();j<size;j++) {
				ft[index++] = bucket[i].get(j);
			}
		}
	}

	public static void main(String[] args) {
		Faculty[] ft = new Faculty[5];
		ft[0] = new Faculty("andre ng", 101 , 12001, "Machine Learning");
		ft[1] = new Faculty("Aarti Bagul", 150, 12001, "Machine Learning");
		ft[2] = new Faculty("Eddy Shyu", 120, 12001, "Machine Learning");
		ft[3] = new Faculty("Geoff Ladwig", 110, 12001, "Machine Learning");
		ft[4] = new Faculty("Kian Katanforoosh", 105, 12002, "Deep Learning");
		

		BuketSortStudent buketSortStudent = new BuketSortStudent();
		buketSortStudent.bucketSort(ft);

		// print the output.
		for (int i = 0; i < ft.length; i++) {
			System.out.println(ft[i]);
		}
		System.out.println("Number of swap require in Merge sort is - " + buketSortStudent.swapCount);

	}


}
