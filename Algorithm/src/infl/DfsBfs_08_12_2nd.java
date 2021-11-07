package infl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 날짜: 2021/11/07
 * 문제: 인프런 DFSBFS 08-12 토마토(BFS 활용)
 */
public class DfsBfs_08_12_2nd {
	static int M,N;
	static int[][] box;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Queue<Point> qu;
	
	static void BFS() {
		while(!qu.isEmpty()) {
			Point tmp = qu.poll();
			
			for(int i=0; i<4; i++) {
				int nx = tmp.x + dx[i];
				int ny = tmp.y + dy[i];
				if(nx >=0 && nx < N && ny >= 0 && ny < M) {
					if(box[nx][ny] == 0) {
						qu.offer(new Point(nx, ny));
						box[nx][ny] = box[tmp.x][tmp.y] + 1;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); //가로
		N = sc.nextInt(); //세론
		box = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				box[i][j] = sc.nextInt();
			}
		}
		
		qu = new LinkedList<Point>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				//시작점이 여러개이기 때문에 BFS시작 전 qu에 넣어놓는다.
				if(box[i][j] == 1) {
					qu.offer(new Point(i, j));
				}
			}
		}
		
		BFS();
		
		boolean flag = true;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			if(!flag) break;
			for(int j=0; j<M; j++) {
				if(box[i][j] == 0) {
					flag = false;
					break;
				} else if (box[i][j] != -1) {
					max = Math.max(max, box[i][j]);
				}
			}
		}
		
		if(!flag) System.out.println(-1);
		else if(max == 1) System.out.println(0);
		else System.out.println(max-1); //가장 처음 익는걸 2로 표현하여서 -1해주어야 함
	}

}
