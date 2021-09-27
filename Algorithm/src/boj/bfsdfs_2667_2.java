package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bfsdfs_2667_2 {
	static int n;
	static int[][] arrMap;
	static boolean[][] visited;
	static int apartNum = 0;
	static int[] aparts;
	//╩С,го,аб,©Л
	static int[] dx = {0, 1, 0, -1}; 
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = stoi(br.readLine());
		arrMap = new int[n][n];
		visited = new boolean[n][n];
		aparts = new int[n*n];
		
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
					apartNum++;
					bfs(i, j);
				}
			}
		}
		
		Arrays.sort(aparts);
		System.out.println(apartNum);
		
		for(int i : aparts) {
			if(aparts[i] != 0) {
				System.out.println(aparts[i]);
			}
		}

	}
	
	public static void bfs(int x, int y) {
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x, y});
		visited[x][y] = true;
		aparts[apartNum]++;
		
		while(!que.isEmpty()) {
			int curX = que.peek()[0];
			int curY = que.peek()[1];
			que.poll();
			
			for(int i=0; i<4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
					if(arrMap[nx][ny] == 1 && !visited[nx][ny]) {
						que.add(new int[] {nx, ny});
						visited[nx][ny] = true;
						aparts[apartNum]++;
					}
				}
			}
		}
		
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
