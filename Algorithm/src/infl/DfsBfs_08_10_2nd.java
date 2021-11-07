package infl;

import java.util.Scanner;

public class DfsBfs_08_10_2nd {
	
	static int[][] map;
	static int answer = 0;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static void DFS(int x, int y) {
		if( x == 6 && y == 6 ) {
			answer++;
		} else {
			for(int i=0; i<4; i++) {
				int nx  = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx <7 && ny >= 0 && ny < 7 && map[nx][ny] == 0) {
					map[nx][ny] = 1;
					DFS(nx, ny);
					map[nx][ny] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[7][7];
		for(int i=0; i<7; i++) {
			for(int j=0; j<7; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		map[0][0] = 1;
		DFS(0, 0);
		
		System.out.println(answer);
	}

}
