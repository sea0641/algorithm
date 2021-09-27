package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 날짜: 2021/08/30
 * 문제: 인프런 DFSBFS 08-11 미로의 최단거리 통로(BFS)
 */
class Point {
	public int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class DfsBfs_08_11 {
	static int[][] arr, dis; //dis: 레벨 단위로 최단거리 쌓아 기록
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static void BFS(int x, int y) {
		Queue<Point> qu = new LinkedList<>(); 
		qu.offer(new Point(x, y));
		
		arr[x][y] = 1;
		
		while(!qu.isEmpty()) {
			Point tmp = qu.poll();
			if(arr[7][7] == 1) return;
			for(int i=0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if ( nx >=1 && nx <= 7 && ny >= 1 && ny <= 7 ) {
					if( arr[nx][ny] == 0 ) {
						arr[nx][ny] = 1;
						qu.offer(new Point(nx, ny));
						dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[8][8];
		dis = new int[8][8];
		for(int i=1; i<=7; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=7; j++) {
				arr[i][j] = stoi(st.nextToken());
			}
		}
		BFS(1, 1);
		if(dis[7][7] == 0) System.out.println(-1);
		else System.out.println(dis[7][7]);
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
