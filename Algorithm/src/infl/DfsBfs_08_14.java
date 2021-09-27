package infl;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 날짜: 2021/08/31
 * 문제: 인프런 DFSBFS 08-14 피자 배달 거리(DFS활용)
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
public class DfsBfs_08_14 {
	static int N, M, len, answer = Integer.MAX_VALUE;
	static ArrayList<Point> pz, hs;
	static int[] combi;
	
	public static void DFS(int L, int s) {
		if(L == M) {
			int sum = 0;
			for(Point h : hs) {
				int dis = Integer.MAX_VALUE;
				for(int i : combi) {
					dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y) );
				}
				sum += dis;
			}
			
			answer = Math.min(answer, sum);
		} else {
			for(int i=s; i<len; i++) {
				combi[L] = i;
				DFS(L+1, i+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		pz = new ArrayList<Point>();
		hs = new ArrayList<Point>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int tmp = sc.nextInt();
				if(tmp == 1) hs.add(new Point(i, j));
				else if(tmp == 2) pz.add(new Point(i, j));
			}
		}
		
		len = pz.size();
		combi = new int[M];
		DFS(0, 0);
		
		System.out.println(answer);
	}

}
