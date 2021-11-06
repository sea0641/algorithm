package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/11/06
 * ����: ������ DFSBFS 08-04 �ߺ�����
 */

/*
 * 1���� N���� ������ ���� �� �ߺ��� ����Ͽ� M�� �̾� �����Ͻÿ�.
 * DFS N�� �б�, ���̴� M
 */
public class DfsBfs_08_04_2nd {
	static int N, M;
	static int[] arr;
	
	static void DFS(int L) {
		
		//M�� ���� ���
		if(L == M) {
			for(int i : arr) System.out.print(i + " ");
			System.out.println();
		} else {
			//N����ŭ �бⰡ DFS �Ͼ��.
			for(int i=1; i<=N; i++) {
				arr[L] = i;
				DFS(L+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //���� ����
		M = sc.nextInt(); //�̴� Ƚ��
		arr = new int[M];
		
		DFS(0);
		
	}

}
