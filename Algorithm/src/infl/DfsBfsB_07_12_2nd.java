package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/11/04
 * 문제: 인프런 DFSBFS기초 07-12 경로탐색(인접행렬,DFS)
 */

/*
 * 방향그래프, 1번에서 n번으로 가는 경우의 수
 * DFS
 */
public class DfsBfsB_07_12_2nd {
	static int n;
	static int[][] arr;
	static boolean[] visited; //정점 방문여부 체크
	static int answer = 0;
	
	public static void DFS(int v) {
		//종료조건
		if( v == n ) {
			answer++;
			return;
		}
		
		//갈 수 있는 다음 노드 방문
		for(int i=1; i<=n; i++) {
			//방향이 있고 방문하지 않았을 때
			if( arr[v][i] == 1 && !visited[i] ) {
				visited[i] = true;
				DFS(i);
				
				//백트래킹, 다음 재탐색 위해 방문여부 풀고 가기
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //정점
		int m = sc.nextInt(); //간선의 수
		arr = new int[n+1][n+1];
		visited = new boolean[n+1];
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = 1;
		}
		
		//첫 노드 방문 체크
		visited[1] = true;
		DFS(1);
		
		System.out.println(answer);
	}

}
