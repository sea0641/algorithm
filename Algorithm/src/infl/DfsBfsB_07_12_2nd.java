package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/11/04
 * ����: ������ DFSBFS���� 07-12 ���Ž��(�������,DFS)
 */

/*
 * ����׷���, 1������ n������ ���� ����� ��
 * DFS
 */
public class DfsBfsB_07_12_2nd {
	static int n;
	static int[][] arr;
	static boolean[] visited; //���� �湮���� üũ
	static int answer = 0;
	
	public static void DFS(int v) {
		//��������
		if( v == n ) {
			answer++;
			return;
		}
		
		//�� �� �ִ� ���� ��� �湮
		for(int i=1; i<=n; i++) {
			//������ �ְ� �湮���� �ʾ��� ��
			if( arr[v][i] == 1 && !visited[i] ) {
				visited[i] = true;
				DFS(i);
				
				//��Ʈ��ŷ, ���� ��Ž�� ���� �湮���� Ǯ�� ����
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //����
		int m = sc.nextInt(); //������ ��
		arr = new int[n+1][n+1];
		visited = new boolean[n+1];
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = 1;
		}
		
		//ù ��� �湮 üũ
		visited[1] = true;
		DFS(1);
		
		System.out.println(answer);
	}

}
