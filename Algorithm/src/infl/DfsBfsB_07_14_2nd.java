package infl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
 * 날짜: 2021/11/04
 * 문제: 인프런 DFSBFS기초 07-14 그래프 최단거리(BFS)
 */

public class DfsBfsB_07_14_2nd {
	
	static List<ArrayList<Integer>> graph;
	static int[] dis; //1번 노드에서 각 노드별 최단거리 수
	static boolean[] visited;
	
	public static void BFS(int v) {
		Queue<Integer> qu = new LinkedList<Integer>();
		qu.offer(v);
		visited[v] = true;
		
		while(!qu.isEmpty()) {
			int tmp = qu.poll();
			
			//현재 qu에서 갈 수 있는 다음 노드들
			for(int nv : graph.get(tmp)) {
				//한번 입력되면 방문되면 패스
				if(!visited[nv]) {
					visited[nv] = true;
					qu.offer(nv);
					
					dis[nv] = dis[v] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //정점의 개수
		int m = sc.nextInt(); //간선의 개수
		
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n; i++)
			graph.add(new ArrayList<>());
		
		for(int i=1; i<=m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph.get(a).add(b);
		}
		
		dis = new int[n+1];
		visited = new boolean[n+1];
		
		BFS(1);
		
		for(int i=2; i<=n; i++) {
			System.out.println(i + " : " + dis[i]);
		} 
	}

}
