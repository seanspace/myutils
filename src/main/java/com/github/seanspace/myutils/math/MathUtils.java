package com.github.seanspace.myutils.math;

/**
 * 数学相关的工具类。
 * 
 * @author liuxb
 * 
 */
public class MathUtils {

	/**
	 * 判断一个整数，是否是偶数。
	 * 
	 * @param n
	 *            被判断的整数。
	 * @return 是：true
	 */
	public static boolean isEven(int n) {
		if (n % 2 == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 通过递归，求幂运算。O(logN)
	 * @param x	底数。
	 * @param n	次方。
	 * @return	
	 */
	public static long pow(long x,int n) {
		if (n== 0) {
			return 1 ;
		} else if (n == 1) {
			return x ;
		} else if (MathUtils.isEven(n)) {
			return pow(x * x, n / 2) ;
		} else {
			return pow(x * x, n / 2) * x ;
		}
	}
	
	/**
	 * 【欧几里得算法】求两个数的最大公因数。
	 * @param m	数1
	 * @param n 数2
	 * @return	返回m和n的最大公因数。
	 */
	public static long gcd(long m, long n) {
		if (m < n) {
			long temp = m ;
			m = n ;
			n = temp ;
		}
		while (n != 0) {
			long rem = m % n ;
			m = n ;
			n = rem ;
		}
		return m;
	}
	

}
