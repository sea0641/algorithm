package infl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 날짜: 2021/08/23
 * 문제: 인프런 DFSBFS기초 07-14 그래프 최단거리(BFS)
 */

public class DfsBfsB_07_14 {
	static int n, m;
	static ArrayList<ArrayList<Integer>> graph;
	static int[] visited, dis;
	
	public void BFS(int v) {
		Queue<Integer> qu = new LinkedList<Integer>();
		visited[v] = 1;
		dis[v] = 0;
		qu.offer(v);
		while(!qu.isEmpty()) {
			int cv = qu.poll();
			for(int nv : graph.get(cv)) {
				if(visited[nv] == 0) {
					visited[nv] = 1;
					qu.offer(nv);
					dis[nv] = dis[cv] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		DfsBfsB_07_14 T = new DfsBfsB_07_14();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		visited = new int[n+1];
		dis = new int[n+1];
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph.get(a).add(b);
		}
		
		T.BFS(1);
		for(int i=2; i<=n; i++) {
			System.out.println(i + " : " + dis[i]);
		}
	}

}
