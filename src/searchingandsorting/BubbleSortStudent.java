package searchingandsorting;

public class BubbleSortStudent {
	int swapCount = 0;

	private void swap(Student[] st, int i, int j) {
		if (st != null) {
			Student temp = st[i];
			st[i] = st[j];
			st[j] = temp;
			swapCount++;
		}
	}
	
	private void bubbleSort(Student[] st) {
		// TODO Auto-generated method stub
		int size = st.length;
		
		for (int i = size-1; i>=0; i--) {
			boolean swapped = false;
			
			for(int j=0;j<i;j++) {
				if(st[j].studentRollNumber > st[j+1].studentRollNumber) {
					swap(st, j, j+1);
					swapped = true;
				}
			}
			
			if(swapped == false) {
				break; // no swapping happened, so break the loop.
			}
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
		
		BubbleSortStudent bubbleSortStudent = new BubbleSortStudent();
		bubbleSortStudent.bubbleSort(st);
		
		//print the output.
		for(int i=0;i<st.length;i++) {
			System.out.println(st[i]);
		}
		System.out.println("Number of swap require in Merge sort is - "+bubbleSortStudent.swapCount);
	}

	
}
