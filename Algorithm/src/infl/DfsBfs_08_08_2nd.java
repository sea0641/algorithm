package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ��¥: 2021/11/07
 * ����: ������ DFSBFS 08-08 ���� �����ϱ�
 */

/*
 * N�� �־����� �Ľ�Į �ﰢ��ó�� ���� ���� �Ʒ����ڰ� F�϶� ù° �� ������ ����
 * �ش� ������ �Ʒ����� ����.. N�� �϶� �� �ڸ����� N-1C0 ~ N-1CN-1 �� ���Ͽ� ���Ѽ� �̴�..
 */
public class DfsBfs_08_08_2nd {
	static int N, F;
	static int[] arr;
	static boolean[] visited;
	static boolean flag = false;
	static int[][] dy = new int[10][10];
	
	/*
	 * ��� + �޸������̼�
	 * nCr = n! / (n-r)!r! �̴�.
	 * nCr = n-1Cr-1 + n-1Cr ��ͷ� ����Ͻÿ�.
	 * ���� �����Ͽ� ���� ��� + ���� �������� �ʰ� ���� ���
	 */
	static int combi(int n, int r) {
		if(dy[n][r] > 0) return dy[n][r];
		if(r == 0 || n == r) return dy[n][r] = 1;
		else return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
	}
	
	static void DFS(int L) {
		if(flag) return;
		
		//���� �迭�� N���� ����� ���� F�� �Ǵ��� Ȯ�� 
		if( L == N ) {
			int sum = 0;
			
			//���Ļ�� ����� ���� ���� ���
			for(int i=0; i<N; i++) {
				sum += arr[i] * combi(N-1, i);
			}
			
			if ( sum == F ) {
				for(int i : arr) System.out.print(i + " ");
				flag = true;
			}
		} else {
			//���� ���ϱ�
			for(int i=0; i<N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					arr[L] = i+1;
					DFS(L+1);
					visited[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //���� N
		F = sc.nextInt(); //���� �� ����
		arr = new int[N];
		visited = new boolean[N];
		
		DFS(0);
	}

}
