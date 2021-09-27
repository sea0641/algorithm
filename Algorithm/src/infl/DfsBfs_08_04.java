package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/29
 * 문제: 인프런 DFSBFS 08-04 중복순열
 */

public class DfsBfs_08_04 {
	static int[] pm;
	static int n,m;
	
	public void DFS(int L) {
		if( L == m ) {
			for(int x : pm) System.out.print(x + " ");
			System.out.println();
		} else {
			for(int i=1; i<=n; i++) {
				pm[L] = i;
				DFS(L+1);
			}
		}
	}
	
	public static void main(String[] args) {
		DfsBfs_08_04 main = new DfsBfs_08_04();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		pm = new int[m];
		main.DFS(0);
	}

}
