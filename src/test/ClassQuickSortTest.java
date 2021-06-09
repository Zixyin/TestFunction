package test;

/**
 * @author YZX
 * @date 2019年10月17日
 * @time 上午8:50:39
 */

public class ClassQuickSortTest {

	public static void main(String[] args) {
		int[] a  = new int[] {1,2,5,2,6,7,5,3,34,8};
		for(int i : a)
			System.out.print(i + " ");
		System.out.println();
		QuickSort(a, 0, a.length - 1);
		for(int i : a)
			System.out.print(i + " ");	
	}
	public static int[] QuickSort(int[] array, int start, int end) {
		if(array.length < 1 || start < 0 || end >= array.length || start > end)
			return null;
		int smallindex  = Partition(array, start, end);
		if(smallindex > start)
			QuickSort(array, start, smallindex - 1);
		if(smallindex < end)
			QuickSort(array, smallindex + 1, end);
		return array;
	}
	public static int Partition(int[] array, int start, int end) {
		int pivot = (int)(start + Math.random() * (end - start + 1));
		swap(array, pivot, end);
		int smallindex = start - 1;
		for(int i = start;i <= end;++ i) {
			if(array[i] <= array[end]) {
				++ smallindex;
			if(smallindex < i)
				swap(array, smallindex, i);
			}
		}
		return smallindex;		
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
