package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 날짜: 2021/06/07
 * 문제: 백준 알고리즘 2667번_단지번호붙이기
 * 설명: 
 */	

public class bfsdfs_2667 {
	static int n;
	static int[][] arrMap;
	static boolean[][] visited;
	static int cnt = 0;
	static List<Integer> house = new ArrayList<>();
	//상,하,좌,우
	static int[] dx = {0, 1, 0, -1}; 
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = stoi(br.readLine());
		arrMap = new int[n][n];
		visited = new boolean[n][n];
		
		String strTmp;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			strTmp = st.nextToken();
			
			for(int j=0; j<n; j++) {
				arrMap[i][j] = strTmp.charAt(j) - '0';
			}
		}

		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j] && arrMap[i][j] == 1) {
					cnt = 1;
					bfs(i, j);
					house.add(cnt);
				}
			}
		}
		
		System.out.println(house.size());
		Collections.sort(house);
		for(int i : house) {
			System.out.println(i);
		}
	}
	
	public static int dfs(int x, int y) {
		visited[x][y] = true;

		for(int i=0; i<4; i++) {
			int x1 = x + dx[i];
			int y1 = y + dy[i];

			if( x1 >= 0 && y1 >= 0 && x1 < n && y1 < n ) {
				if (!visited[x1][y1] && arrMap[x1][y1] == 1) {
					cnt++;
					dfs(x1, y1);
				}
			}
		}
		
		return cnt;
	}
	
	public static int bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x, y});
		
		while(!que.isEmpty()) {
			visited[x][y] = true;
			
			int qX = que.peek()[0];
			int qY = que.peek()[1];
			que.poll();
			
			for(int i=0; i<4; i++) {
				int x1 = qX + dx[i];
				int y1 = qY + dy[i];
				
				if(x1 >= 0 && y1 >= 0 && x1 < n && y1 < n) {
					if(arrMap[x1][y1] == 1 && !visited[x1][y1]) {
						cnt++;
						que.add(new int[] {x1, y1});
						visited[x1][y1] = true;
					}
				}
			}
		}
		
		return cnt;
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
