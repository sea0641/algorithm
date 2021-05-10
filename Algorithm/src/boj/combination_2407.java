package boj;

import java.math.BigDecimal;
import java.util.Scanner;

/*
 * ��¥: 2021/05/10
 * ����: ���� �˰��� 2407��_����
 * ����: ���, �ڷ��� ����
 */

public class combination_2407 {
	
	static int n;
	static int m;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		//nCr = n! / (n-r)!*r!
		BigDecimal nFac = fact(n);
		BigDecimal n_mFac = fact(n-m);
		BigDecimal mFac = fact(m);
		BigDecimal comb = BigDecimal.ZERO;
		comb = nFac.divide(n_mFac.multiply(mFac));
		
		System.out.println(comb);
		
	}
	
	public static BigDecimal fact(int i) {
		return i>1 ? fact(i-1).multiply(new BigDecimal(i)) : BigDecimal.ONE;
	}

}
