package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/29
 * ����: ������ DFSBFS 08-07 ������ ����(�޸������̼�)
 */

public class DfsBfs_08_07 {
	static int[][] arr; //�޸������̼�
	
	public static int DFS(int n, int r) {
		if(arr[n][r] > 0) return arr[n][r];
		if(n == r || r == 0) return 1;
		else return DFS(n-1, r-1) + DFS(n-1, r); //�ڽ��� ���Ե� ��� + ���Ե��� ���� ���
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		arr = new int[n+1][r+1];
		
		System.out.println(DFS(n, r));
	}

}
