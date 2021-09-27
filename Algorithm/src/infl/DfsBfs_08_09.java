package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/29
 * ����: ������ DFSBFS 08-09 ���� ���ϱ�
 */

public class DfsBfs_08_09 {
	static int[] combi;
	static int n, m;
	
	public void DFS(int L, int s) {
		if(L == m) {
			for(int x : combi) System.out.print(x + " ");
			System.out.println();
		} else {
			for(int i=s; i<=n; i++) {
				combi[L] = i;
				DFS(L+1, i+1);
			}
		}
	}
	
	public static void main(String[] args) {
		DfsBfs_08_09 main = new DfsBfs_08_09();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		combi = new int[m];
		main.DFS(0, 1);
	}

}
