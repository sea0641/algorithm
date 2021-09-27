package infl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 날짜: 2021/08/31
 * 문제: 인프런 DFSBFS 08-12 토마토(BFS 활용)
 */
/*
class Point {
	public int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
*/

public class DfsBfs_08_12 {
	static int n,m;
	static int[][] box, dis;
	static Queue<Point> qu;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static void BFS() {
		while(!qu.isEmpty()) {
			Point tmp = qu.poll();
			for(int i=0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				
				if(nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
					if(box[nx][ny] == 0) {
						box[nx][ny] = 1; //방문표시
						qu.offer(new Point(nx, ny));
						dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		box = new int[n+1][m+1];
		dis = new int[n+1][m+1];
		for(int i=1; i <= n; i++) {
			for(int j=1; j <= m; j++) {
				box[i][j] = sc.nextInt();
			}
		}
		
		qu = new LinkedList<>();
		for(int i=1; i<= n; i++) {
			for(int j=1; j <= m; j++) {
				if (box[i][j] == 1 ) qu.offer(new Point(i, j));
			}
		}
		
		BFS();
		boolean flag = true;
		int answer = Integer.MIN_VALUE;
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				if(box[i][j] == 0) flag = false; //익지않은 토마토 존재
			}
		}
		if(flag) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=m; j++) {
					answer = Math.max(answer, dis[i][j]);
				}
			}
			System.out.println(answer);
		} else System.out.println(-1);
		
		
	}

}
