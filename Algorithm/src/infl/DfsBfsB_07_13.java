package infl;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * ��¥: 2021/08/23
 * ����: ������ DFSBFS���� 07-13 ���Ž��(��������Ʈ, ArrayList)
 */

public class DfsBfsB_07_13 {
	static int n, m, answer = 0;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] visited;
	
	public void DFS(int v) {
		if(v == n) answer++;
		else {
			for(int nv : graph.get(v)) {
				if(visited[nv] == 0) {
					visited[nv] = 1;
					DFS(nv);
					visited[nv] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		DfsBfsB_07_13 T = new DfsBfsB_07_13();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //������ ����
		m = sc.nextInt(); //������ ����
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		visited = new int[n+1];
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
		}
		
		visited[1] = 1;
		T.DFS(1);
		
		System.out.println(answer);
	}

}
