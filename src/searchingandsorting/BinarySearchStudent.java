package searchingandsorting;

public class BinarySearchStudent {
	
	int countComparision = 0;
	
	public static void main(String[] args) {
		//create student objects and store in array.
		Student[] st = new Student[5];
		st[0] = new Student("ame", 10, 80);
		st[1] = new Student("roy", 7, 69);
		st[2] = new Student("tommy", 3, 59);
		st[3] = new Student("cool", 9, 75);
		st[4] = new Student("jon", 1, 67);
		
		
		BinarySearchStudent binarySearchStudent = new BinarySearchStudent();
		int index = binarySearchStudent.search(st, 0, st.length-1, st[1]);
		System.out.println("student found at index : "+index);
		
		System.out.println("Number of swap require in Merge sort is - "+binarySearchStudent.countComparision);
	}

	private int search(Student[] st, int left, int right, Student student) {
		if(left <= right) {
			int mid = left+(right-left)/2;
			countComparision++;
			if(st[mid].equals(student)) {
				return mid;
			}else if(st[mid].studentRollNumber > student.studentRollNumber) {
				left = mid+1;
				return search(st, left, right, student);
			} else {
				right = mid-1;
				return search(st, left, right, student);
			}
		}
		return -1;
	}


	
	
}
