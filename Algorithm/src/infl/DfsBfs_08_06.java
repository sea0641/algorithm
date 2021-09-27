package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/29
 * 문제: 인프런 DFSBFS 08-06 순열 구하기
 */
public class DfsBfs_08_06 {
	static int[] pm, arr;
	static int n,m;
	static boolean[] ch;
	
	public void DFS(int L) {
		if(L == m) {
			for(int x : pm) System.out.print(x + " ");
			System.out.println();
		} else {
			for(int i=0; i<n; i++) {
				if(!ch[i]) {
					ch[i] = true;
					pm[L] = arr[i];
					DFS(L+1);
					ch[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		DfsBfs_08_06 main = new DfsBfs_08_06();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		ch = new boolean[n];
		pm = new int[m];
		main.DFS(0);
	}

}
