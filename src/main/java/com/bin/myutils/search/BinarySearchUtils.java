package com.bin.myutils.search;
/**
 * 折半查找<br>
 * 时间复杂度，O(logN)，对于不经常插入和删除，相对固定的已经排好序的数据，用此方法。如：元素周期表。
 * @author liuxb
 *
 */
public class BinarySearchUtils {
	public static final int NOT_FOND = -1 ;
	
	/**
	 * 折半查找<br>
	 * 时间复杂度，O(logN)，对于不经常插入和删除，相对固定的已经排好序的数据，用此方法。如：元素周期表。
	 * @param a	排序后数组。
	 * @param x 被查找数。
	 * @return	返回数组的下标。
	 */
	public static <AnyType extends Comparable<? super AnyType>>
	int binarySearch(AnyType [] a, AnyType x) {
		
		int low = 0 ,high = a.length -1 ;
		
		while (low <= high) {
			int mid = (low + high) / 2 ;
			
			int compareRes = a[mid].compareTo(x);
			if (compareRes < 0) {
				low = mid + 1 ;
			} else if(compareRes > 0) {
				high = mid - 1 ;
			} else {
				//相等
				return mid ;
			}
		}
		return NOT_FOND ;
	}

}
