package infl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 날짜: 2021/11/03
 * 문제: 인프런 DFSBFS기초 07-08 송아지 찾기 1(BFS: 상태트리탐색)
 */

/*
 * 점프의 최소 횟수(최단거리) -> BFS
 * 1, -1, 5 분기
 */
public class DfsBfsB_07_08_2nd {

	static int e;
	
	static void BFS(int dis) {
		Queue<Integer> qu = new LinkedList<Integer>();
		boolean[] visited = new boolean[10001];
		visited[dis] = true;
		qu.offer(dis);
		
		int level = 0;
		while(!qu.isEmpty()) {
			int len = qu.size();
			//qu의 현재 개수만큼 가지를 뻗어나간다.
			for(int i=0; i<len; i++) {
				int x = qu.poll();
				
				if( x == e ) {
					System.out.println(level);
					return;
				}
				
				if(x < e) {
					if(!visited[x+1]) {
						qu.offer(x+1);
						visited[x+1] = true;
					}
					if(!visited[x+5]) {
						qu.offer(x+5);
						visited[x+5] = true;
					}
				} else {
					if(!visited[x-1]) {
						qu.offer(x-1);
						visited[x-1] = true;
					}
				}
			}
			
			level++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt(); //현수의 위치
		e = sc.nextInt(); //송아지의 위치
		
		BFS(s);
	}

}
