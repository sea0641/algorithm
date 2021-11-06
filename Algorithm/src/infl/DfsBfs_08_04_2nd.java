package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/11/06
 * 문제: 인프런 DFSBFS 08-04 중복순열
 */

/*
 * 1부터 N까지 구슬이 있을 때 중복을 허락하여 M번 뽑아 나열하시오.
 * DFS N번 분기, 깊이는 M
 */
public class DfsBfs_08_04_2nd {
	static int N, M;
	static int[] arr;
	
	static void DFS(int L) {
		
		//M번 차면 출력
		if(L == M) {
			for(int i : arr) System.out.print(i + " ");
			System.out.println();
		} else {
			//N번만큼 분기가 DFS 일어난다.
			for(int i=1; i<=N; i++) {
				arr[L] = i;
				DFS(L+1);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //구슬 개수
		M = sc.nextInt(); //뽑는 횟수
		arr = new int[M];
		
		DFS(0);
		
	}

}
