package boj;

/*
 * 날짜: 2021/04/14
 * 문제: 백준 알고리즘 2644번_촌수계산
 * 설명: DFS는 재귀, BFS는 Queue 사용
 * 		백트래킹, 재귀함수 전부 종료.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bfsdfs_2644 {
	static int n; //전체 사람의 수
	static int m; //부모 자식들간의 관계의 개수
	static List<Integer>[] list;
	static boolean[] visit;
	static int c = 0; //촌수
	static int p1;
	static int p2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		visit = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		int c1;
		int c2;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			c1 = Integer.parseInt(st.nextToken());
			c2 = Integer.parseInt(st.nextToken());
			
			list[c1].add(c2);
			list[c2].add(c1);
		}
		
		dfs(p1);
		
		System.out.println(-1);
		
	}
	
	static void dfs(int now) {
		visit[now] = true; //방문처리
		
		c++; //촌수 증가
		
		for(int next : list[now]) {
			if(!visit[next]) {
				//방문한 적이 없고 목표에 다다르지 못했다면 dfs재귀호출한다
				if(next != p2) {
					dfs(next);
				}
				//방문한 적이 없고 목표에 이르렀다면 재귀함수 모두 종료
				else if(next == p2) {
					System.out.println(c);
					System.exit(0);
				}
			}
		}
		
		c--; //백트래킹
	}
}
