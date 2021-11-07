package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/11/08
 * 문제: 인프런 DFSBFS 08-07 조합의 경우수(메모이제이션)
 */

/*
 * nCr = n! / (n-r)!r! 이다.
 * nCr = n-1Cr-1 + n-1Cr 재귀로 계산하시오.
 * 나를 포함하여 뽑은 경우 + 나를 포함하지 않고 뽑은 경우
 */
public class DfsBfs_08_07_2nd {
	//메모이제이션
	static int[][] dy = new int[35][35];
	
	static int DFS(int n, int r) {
		
		//이미 구한적 있으면 바로 리턴
		if(dy[n][r] > 0) return dy[n][r];
		
		//가장 말단, 1 리턴 조건, 1C1, 1C0
		if(n == r || r == 0) return 1;
		else return dy[n][r] = DFS(n-1, r-1) + DFS(n-1, r);
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		
		if(n-r < r ) r = n-r;
		
		System.out.println(DFS(n, r));
		
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0);
	}

}
