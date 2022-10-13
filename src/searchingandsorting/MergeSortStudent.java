package searchingandsorting;

public class MergeSortStudent {
	int swapCount = 0;
	
	private void swap(Student[] st, int i, int j) {
		if(st!=null) {
			Student temp = st[i];
			st[i] = st[j];
			st[j] = temp;
			swapCount++;
		}
	}
	
	
	private void merge(Student[] st, int left, int mid, int right) {
		
		int n1 = mid - left + 1;
		int n2 = right - mid;
		
		Student L[] = new Student[n1];
		Student M[] = new Student[n2];
		
		for(int i=0;i<n1;i++) {
			L[i] = st[left + i];
		}
		for(int j=0;j<n2;j++) {
			M[j] = st[mid+1+j];
		}
		
		int i=0;
		int j=0;
		int k=left;
		
		while(i<n1 && j<n2) {
			if(L[i].studentRollNumber <= M[j].studentRollNumber) {
				st[k] = L[i];
				i++;
			} else {
				swapCount++; //count the swap
				st[k] = M[j];
				j++;
			}
			k++;
		}
		
		// when we run out of elements in either L or M.
		// pick up the remaining elements and put in A[p..r]
		while(i < n1) {
			st[k] = L[i];
			i++;
			k++;
			
		}
		
		while(j < n2) {
			st[k] = M[j];
			j++;
			k++;
		}
		
		
	}



	private void mergeSort(Student[] st, int left, int right) {
		
		if(left < right) {
			// m is the point where 
			int mid = left + (right - left) / 2;
			mergeSort(st, left, mid);
			mergeSort(st, mid+1, right);
			// Merge the sorted sub arrays.
			merge(st, left, mid, right);
		}
	}
	
	

	public static void main(String[] args) {
		//create student objects and store in array.
		Student[] st = new Student[5];
		st[0] = new Student("ame", 10, 80);
		st[1] = new Student("roy", 7, 69);
		st[2] = new Student("tommy", 3, 59);
		st[3] = new Student("cool", 9, 75);
		st[4] = new Student("jon", 1, 67);
		
		MergeSortStudent mergeSortStudent = new MergeSortStudent();
		mergeSortStudent.mergeSort(st, 0, st.length-1);
		
		//print the output.
		for(int i=0;i<st.length;i++) {
			System.out.println(st[i]);
		}
		System.out.println("Number of swap require in Merge sort is - "+mergeSortStudent.swapCount);
	}


}
