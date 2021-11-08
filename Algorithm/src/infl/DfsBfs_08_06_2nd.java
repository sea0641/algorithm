package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/11/06
 * ����: ������ DFSBFS 08-06 ���� ���ϱ�
 */

/*
 * 10������ N�� �ڿ��� �� M���� �̾� ����
 * ����(�ߺ�X), ���� ���� �迭 �ʿ�, �ߺ�������� �����Ƿ� �湮���� �迭 üũ + ��Ʈ��ŷ
 */
public class DfsBfs_08_06_2nd {
	static int N, M;
	static int[] arr;
	static int[] pm; //���� �迭
	static boolean[] visited;
	
	static void DFS(int L) {
		if( L == M ) {
			for(int i : pm) System.out.print(i + " ");
			System.out.println();
		} else {
			for(int i=0; i<N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					pm[L] = arr[i];
					DFS(L+1);
					visited[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //N�� �ڿ���
		visited = new boolean[N];
		M = sc.nextInt(); //�̴� ����
		arr = new int[N];
		pm = new int[M];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		
		DFS(0);
	}

}
