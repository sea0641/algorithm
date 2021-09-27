package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/29
 * 문제: 인프런 DFSBFS 08-07 조합의 경우수(메모이제이션)
 */

public class DfsBfs_08_07 {
	static int[][] arr; //메모이제이션
	
	public static int DFS(int n, int r) {
		if(arr[n][r] > 0) return arr[n][r];
		if(n == r || r == 0) return 1;
		else return DFS(n-1, r-1) + DFS(n-1, r); //자신이 포함된 경우 + 포함되지 않은 경우
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		arr = new int[n+1][r+1];
		
		System.out.println(DFS(n, r));
	}

}
