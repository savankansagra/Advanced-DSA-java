package searchingandsorting;

import java.util.Objects;

class Faculty {
	
	String faculty_name;
	Integer faculty_ID;
	Integer subject_codes;
	String class_names;
	
	public Faculty(String faculty_name, Integer faculty_ID, Integer subject_codes, String class_names) {
		super();
		this.faculty_name = faculty_name;
		this.faculty_ID = faculty_ID;
		this.subject_codes = subject_codes;
		this.class_names = class_names;
	}

	@Override
	public int hashCode() {
		return Objects.hash(class_names, faculty_ID, faculty_name, subject_codes);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Faculty other = (Faculty) obj;
		return Objects.equals(class_names, other.class_names) && Objects.equals(faculty_ID, other.faculty_ID)
				&& Objects.equals(faculty_name, other.faculty_name)
				&& Objects.equals(subject_codes, other.subject_codes);
	}

	
	@Override
	public String toString() {
		return "Faculty [faculty_name=" + faculty_name + ", faculty_ID=" + faculty_ID + ", subject_codes="
				+ subject_codes + ", class_names=" + class_names + "]";
	}
	
	
}


public class RadixSortFaculty {
	
	int swapCount = 0;
	
	private void countingSort(Faculty[] ft, int length, int place) {
		Faculty[] output = new Faculty[length+1];
		Faculty max = ft[0];
		for(int i=1 ; i<length ; i++) {
			if(ft[i].faculty_ID > max.faculty_ID) {
				max=ft[i];
			}
		}
		int[] count = new int[max.faculty_ID + 1];
		
		for(int i=0 ; i<max.faculty_ID; i++ ) {
			count[i] = 0;
		}
		
		//calculate count of elements.
		for(int i=0; i<length; i++) {
			count[ft[i].faculty_ID] += 1;
		}
		
		// cumulative count
		for(int i=1, size = max.faculty_ID; i<=size ;i++) {
			count[i] += count[i-1];
		}
		
		//place the element in sorted order
		for(int i=length-1 ; i>=0 ; i--) {
			output[count[(ft[i].faculty_ID/place) % 10]] = ft[i];
			count[(ft[i].faculty_ID/place)%10] -= 1;
		}
		
		// put value in original array.
		for(int i=0;i<length;i++) {
			ft[i] = output[i];
		}
		
		
		
	}
	
	private int getMax(Faculty[] ft) {
		Faculty max = ft[0];
		for(int i=1, size = ft.length; i<size; i++) {
			if(max.faculty_ID < ft[i].faculty_ID) {
				max = ft[i];
			}
		}
		return max.faculty_ID;
	}
	
	private void radixsort(Faculty[] ft, int length) {
		//Get Maximum element
		int max = getMax(ft);
		
		// Apply counting sort to sort elements based on place value.
		for(int place=1; max/place > 0; place *= 10) {
			countingSort(ft, ft.length, place);
		}
		
		
	}



	

	public static void main(String[] args) {
		//create the faculty objects.
		Faculty[] ft = new Faculty[5];
		ft[0] = new Faculty("andre ng", 101 , 12001, "Machine Learning");
		ft[1] = new Faculty("Aarti Bagul", 150, 12001, "Machine Learning");
		ft[2] = new Faculty("Eddy Shyu", 120, 12001, "Machine Learning");
		ft[3] = new Faculty("Geoff Ladwig", 110, 12001, "Machine Learning");
		ft[4] = new Faculty("Kian Katanforoosh", 105, 12002, "Deep Learning");
		
		RadixSortFaculty radixSort = new RadixSortFaculty();
		radixSort.radixsort(ft, ft.length);
		
		//print the output.
		for(int i=0;i<ft.length;i++) {
			System.out.println(ft[i]);
		}
//		System.out.println("Number of swap require in radix sort is : "+radixSort.swapCount);
	}

	
	
}
