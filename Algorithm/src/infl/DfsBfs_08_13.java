package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/31
 * 문제: 인프런 DFSBFS 08-13 섬나라 아일랜드
 */

public class DfsBfs_08_13 {
	static int N;
	static int[][] board;
	//static boolean[][] visited;
	static int answer = 0;
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static void DFS(int x, int y) {
		//visited[x][y] = true;
		board[x][y] = 0;
		
		for(int i=0; i< 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx >= 1 && nx <= N && ny >=1 && ny <= N) {
				if(board[nx][ny] == 1) { //&& !visited[nx][ny]
					DFS(nx, ny);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new int[N+1][N+1];
		//visited = new boolean[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++)
				board[i][j] = sc.nextInt();
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(board[i][j] == 1) { //&& !visited[i][j]
					DFS(i, j);
					answer++;
				}
			}
		}
		
		System.out.println(answer);
		
	}

}
