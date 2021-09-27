package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/23
 * ����: ������ DFSBFS���� 07-12 ���Ž��(DFS)
 */

public class DfsBfsB_07_12 {
	static int n, m, answer = 0;
	static int[][] graph;
	static int[] visited;
	
	public void DFS(int v) {
		if(v == n) answer++;
		else {
			for(int i=1; i<=n; i++) {
				if(graph[v][i] == 1 && visited[i] == 0) {
					visited[i] = 1; //�湮
					DFS(i);
					visited[i] = 0; //�湮���
				}
			}
		}
	}
	
	public static void main(String[] args) {
		DfsBfsB_07_12 T = new DfsBfsB_07_12();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //������ ����
		m = sc.nextInt(); //������ ����
		graph = new int[n+1][n+1];
		visited = new int[n+1];
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
		}
		
		visited[1] = 1;
		T.DFS(1);
		
		System.out.println(answer);
	}

}
