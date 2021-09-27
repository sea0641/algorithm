package infl;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 날짜: 2021/08/23
 * 문제: 인프런 DFSBFS기초 07-13 경로탐색(인접리스트, ArrayList)
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
		n = sc.nextInt(); //정점의 개수
		m = sc.nextInt(); //간선의 개수
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
