package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/11/07
 * ����: ������ DFSBFS 08-09 ���� ���ϱ�
 */

/*
 * ������ ������ ������� �ʴ´�. �׷��� ������ �� �տ��� ���� Ž���� �ʿ� X
 * ������ ���ڸ� Ž������ �ʱ⶧���� visited �迭�� �ʿ� X
 */
public class DfsBfs_08_09_2nd {
	static int N, M;
	static int[] combi;
	
	static void DFS(int L, int s) {
		if ( L == M ) {
			for(int c : combi) System.out.print(c + " ");
			System.out.println();
		} else {
			for(int i=s; i<=N; i++) {
				combi[L] = i;
				DFS(L+1, i+1);
				//DFS(L+1, i); �ߺ�����
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //��ü ���� ����
		M = sc.nextInt(); //�̴� ����
		combi = new int[M];
		
		DFS(0, 1);
	}

}
