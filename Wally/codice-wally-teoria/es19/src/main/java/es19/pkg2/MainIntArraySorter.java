package es19.pkg2;

import java.util.Arrays;

public class MainIntArraySorter {
	public static void main(String[] args) {
		IntArraySorter sorter = new IntArraySorter();
		Integer[] arr = new Integer[] {4,2,3,1};
		sorter.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
