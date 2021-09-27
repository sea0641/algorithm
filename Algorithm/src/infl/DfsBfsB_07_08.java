package infl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * 날짜: 2021/08/23
 * 문제: 인프런 DFSBFS기초 07-08 송아지 찾기 1(BFS: 상태트리탐색)
 */

public class DfsBfsB_07_08 {
	static int e;
	int[] jump = {1, -1, 5};
	int[] visited;
	Queue<Integer> qu = new LinkedList<Integer>();
	int answer = 0;
	
	public int BFS(int s) {
		visited = new int[10001];
		visited[s] = 1;
		qu.offer(s);
		int L = 0; //레벨
		while(!qu.isEmpty()) {
			int len = qu.size();
			for(int i=0; i<len; i++) {
				int x = qu.poll();

				for(int j : jump) {
					int nx = x + j;
					
					if( nx == e ) return L+1;
					
					if(nx >= 1 && nx <= 10000 && visited[nx] == 0) {
						visited[nx] = 1;
						qu.offer(nx);
					}
				}
			}
			
			L++;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		DfsBfsB_07_08 T = new DfsBfsB_07_08();
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt(); //현수의 위치
		e = sc.nextInt(); //송아지의 위치
		
		System.out.println(T.BFS(s));
	}
	
	

}
