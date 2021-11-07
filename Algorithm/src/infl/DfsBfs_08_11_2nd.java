package infl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 날짜: 2021/11/07
 * 문제: 인프런 DFSBFS 08-11 미로의 최단거리 통로(BFS)
 */

//class Point {
//	int x, y;
//	
//	Point(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}
public class DfsBfs_08_11_2nd {
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	static void BFS(int x, int y) {
		Queue<Point> qu = new LinkedList<Point>();
		qu.offer(new Point(x, y));
		
		while(!qu.isEmpty()) {
			Point tmp = qu.poll();
			
			if(tmp.x == 6 && tmp.y == 6) break;
			
			for(int i=0; i<4; i++) {
				int nx  = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx >= 0 && nx < 7 && ny >= 0 && ny < 7 && map[nx][ny] == 0) {
					map[nx][ny] = map[tmp.x][tmp.y] + 1;
					qu.offer(new Point(nx, ny));
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
		
		BFS(0, 0);
		
		if(map[6][6] == 0) System.out.println(-1);
		else System.out.println(map[6][6]);
	}

}
