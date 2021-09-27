package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 날짜: 2021/08/30
 * 문제: 인프런 DFSBFS 08-10 미로탐색(DFS)
 */

public class DfsBfs_08_10 {
	static int[][] arr;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int answer = 0;
	
	static void DFS(int x, int y) {
		if(x == 6 && y == 6) {
			answer++;
		} else {
			arr[x][y] = 1;
					
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx >= 0 && nx < 7 && ny >= 0 && ny < 7 ) {
					if(arr[nx][ny] == 0) {
						DFS(nx, ny);
						arr[nx][ny] = 0;
					}
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[7][7];
		for(int i=0; i<7; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<7; j++) {
				arr[i][j] = stoi(st.nextToken());
			}
		}

		DFS(0, 0);
		System.out.println(answer);
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
