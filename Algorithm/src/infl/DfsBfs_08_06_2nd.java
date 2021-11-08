package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/11/06
 * 문제: 인프런 DFSBFS 08-06 순열 구하기
 */

/*
 * 10이하의 N개 자연수 중 M개를 뽑아 나열
 * 순열(중복X), 순서 담을 배열 필요, 중복허용하지 않으므로 방문여부 배열 체크 + 백트래킹
 */
public class DfsBfs_08_06_2nd {
	static int N, M;
	static int[] arr;
	static int[] pm; //순열 배열
	static boolean[] visited;
	
	static void DFS(int L) {
		if( L == M ) {
			for(int i : pm) System.out.print(i + " ");
			System.out.println();
		} else {
			for(int i=0; i<N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					pm[L] = arr[i];
					DFS(L+1);
					visited[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //N개 자연수
		visited = new boolean[N];
		M = sc.nextInt(); //뽑는 개수
		arr = new int[N];
		pm = new int[M];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		
		DFS(0);
	}

}
