package infl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 날짜: 2021/11/04
 * 문제: 인프런 DFSBFS기초 07-13 경로탐색(인접리스트, ArrayList)
 */

public class DfsBfsB_07_13_2nd {

	static int n;
	static List<ArrayList<Integer>> graph;
	static boolean[] visited; //정점 방문여부 체크
	static int answer = 0;
	
	public static void DFS(int v) {
		//종료조건
		if( v == n ) {
			answer++;
			return;
		}
		
		//갈 수 있는 다음 노드 방문
		for(int nv : graph.get(v)) {
			//방향이 있고 방문하지 않았을 때
			if( nv == 1 && !visited[nv] ) {
				visited[nv] = true;
				DFS(nv);
				
				//백트래킹, 다음 재탐색 위해 방문여부 풀고 가기
				visited[nv] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //정점
		int m = sc.nextInt(); //간선의 수
		visited = new boolean[n+1];
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph.get(a).add(b);
		}
		
		//첫 노드 방문 체크
		visited[1] = true;
		DFS(1);
		
		System.out.println(answer);
	}

}
