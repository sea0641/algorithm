package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/29
 * ����: ������ DFSBFS 08-03 �ִ����� ���ϱ�(DFS)
 */

public class DfsBfs_08_03 {
	static int n, m, arr[][];
	static int score = 0;
	
	public static void DFS(int L, int sum, int time) {
		if(time > m) return;
		
		if(L == n)
			score = Math.max(score, sum);
		else {
			DFS(L+1, sum + arr[L][0], time + arr[L][1]);
			DFS(L+1, sum, time);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt(); //���� ����
		m = sc.nextInt(); //���ѽð�
		arr = new int[n][2];
		for(int i=0; i<n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		DFS(0, 0, 0);
		System.out.println(score);
	}

}
