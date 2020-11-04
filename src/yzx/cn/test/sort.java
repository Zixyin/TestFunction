package yzx.cn.test;

/**
 * @author YZX
 * @date 2019年9月10日
 * @time 上午10:27:39
 */

public class sort {

	//冒泡排序
	public static int[] bubbleSort(int[] array) {
		if(array.length == 0) {
			return array;
		}
		for(int i = 0;i < array.length;i ++)
			for(int j = 0;j < array.length - 1 - i;j ++)
			{
				if(array[j+1] < array[j]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		return array;
	}
	
	//选择排序
	public static int[] selectSort(int[] array) {
		if(array.length == 0){
			return array;
		}
		for(int i = 0; i < array.length;i ++) {
			int minIndex = i;
			for(int j = i;j < array.length - 1;j ++) {
				if(array[j+1] < array[j]) 
					minIndex = j + 1;
			}
			int temp = array[i];
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
		return array;
	}
	
	//插入排序
	public static int[] insertSort(int[] array) {
		if(array.length == 0) {
			return array;
		}
		for(int i = 0; i < array.length - 1;i ++) {
			int current = array[i + 1];
			int preIndex = i;
			while(preIndex >= 0 && current <  array[preIndex]) {
				array[preIndex +1 ] = array[preIndex];
				preIndex --;
			}
			array[preIndex + 1] = current;
		}
		return array;
	}
	
	//希尔排序
	public static int[] shellSort(int[] array) {
		if(array.length == 0) {
			return array;
		}
	    int gap = array.length;
	    while (true) {    
	        gap /= 2;   //增量每次减半    
	        for (int i = 0; i < gap; i++) {        
	            for (int j = i + gap; j < array.length; j += gap) {//这个循环里其实就是一个插入排序            
	                int current = array[j];            
	                int preIndex = j - gap;            
	                while (preIndex >= 0 && array[preIndex] > current) {                
	                    array[preIndex + gap] = array[preIndex];                
	                    preIndex -= gap;            
	                }            
	                array[preIndex + gap] = current;        
	            }    
	        }    
	        if (gap == 1)        
	            break;
	    }
	    return array;
	}
	
	public static void main(String[] args) {
		int a[] = {3,44,38,5,47,15,36,26,27,2,46,4,19,50,48};
	//	a = bubbleSort(a);
	//	a = selectSort(a);
	//	a = insertSort(a);
	//	a = shellSort(a);
		for(int i = 0;i < a.length;i ++)
		System.out.print(a[i]+" ");
	}
}
	