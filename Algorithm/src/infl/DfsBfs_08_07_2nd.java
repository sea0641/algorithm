package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/11/08
 * ����: ������ DFSBFS 08-07 ������ ����(�޸������̼�)
 */

/*
 * nCr = n! / (n-r)!r! �̴�.
 * nCr = n-1Cr-1 + n-1Cr ��ͷ� ����Ͻÿ�.
 * ���� �����Ͽ� ���� ��� + ���� �������� �ʰ� ���� ���
 */
public class DfsBfs_08_07_2nd {
	//�޸������̼�
	static int[][] dy = new int[35][35];
	
	static int DFS(int n, int r) {
		
		//�̹� ������ ������ �ٷ� ����
		if(dy[n][r] > 0) return dy[n][r];
		
		//���� ����, 1 ���� ����, 1C1, 1C0
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
