package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/11/07
 * 문제: 인프런 DFSBFS 08-13 섬나라 아일랜드
 */

public class DfsBfs_08_13_2nd {
	static int N;
	static int[][] map;
	static int[] dx = {1, 1, 0, -1, -1, -1,  0, 1};
	static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

	static void DFS(int x, int y) {
		//방문체크
		map[x][y] = 0;
		
		for(int i=0; i<8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if(map[nx][ny] == 1) {
//					map[nx][ny] = 0;
					DFS(nx, ny);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		int answer = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					answer++;
//					map[i][j] = 0;
					 DFS(i, j);
				}
			}
		}
		
		System.out.println(answer);
	}

}
