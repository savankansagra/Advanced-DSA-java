package searchingandsorting;

class Student{
	public String studentName;
	public int studentRollNumber;
	public int totalMarks;
	
	public Student() {
		super();
	}

	public Student(String studentName, int studentRollNumber, int totalMarks) {
		super();
		this.studentName = studentName;
		this.studentRollNumber = studentRollNumber;
		this.totalMarks = totalMarks;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentRollNumber=" + studentRollNumber + ", totalMarks="
				+ totalMarks + "]";
	}	
	
	
}

public class QuickSortStudent {
	
	int swapCount = 0;
	
	private void swap(Student[] st, int i, int j) {
		if(st!=null) {
			Student temp = st[i];
			st[i] = st[j];
			st[j] = temp;
			swapCount++;
		}
	}
	

	private int partition(Student[] st, int low, int high) {
		// choose the rightmost element as pivot.
		Student pivot = st[high];
		
		// pointer for greater element
		int i = low - 1;
		
		//traverse through all elements
		//compare each element with pivot.
		for(int j=low; j<high; j++) {
			if(st[j].studentRollNumber < pivot.studentRollNumber) {
				i++;
				swap(st, i, j); //putting all lower element in left part.
			}
		}
		
		//swap the pivot element with the greater element specified by i
		swap(st, i+1, high);
		
		// return the position from where the partition is done.
		return (i+1);
	}


	public void quickSort(Student[] st, int low, int high) {
		if(low < high) {
			/*
			 * find the pivot element such that 
			 * elements smaller than pivot are on the left
			 * elements greater than pivot are on the right
			 */
			int pi = partition(st, low, high);
			
			//recursive call on the left of pivot
			quickSort(st, low, pi-1);
			
			//recursive call on the right of pivot
			quickSort(st, pi+1, high);
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
		
		//
		QuickSortStudent quickSortStudent = new QuickSortStudent();
		quickSortStudent.quickSort(st, 0, st.length-1);
		
		
		//print the output.
		for(int i=0;i<st.length;i++) {
			System.out.println(st[i]);
		}
		System.out.println("Number of swap require in quick sort is - "+quickSortStudent.swapCount);
		
	}
}
