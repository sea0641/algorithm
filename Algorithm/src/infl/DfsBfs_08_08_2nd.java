package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 날짜: 2021/11/07
 * 문제: 인프런 DFSBFS 08-08 수열 추측하기
 */

/*
 * N이 주어지고 파스칼 삼각형처럼 더해 가장 아래숫자가 F일때 첫째 줄 수열을 구할
 * 해당 수열의 아래숫자 계산법.. N개 일때 각 자리수에 N-1C0 ~ N-1CN-1 을 곱하여 더한수 이다..
 */
public class DfsBfs_08_08_2nd {
	static int N, F;
	static int[] arr;
	static boolean[] visited;
	static boolean flag = false;
	static int[][] dy = new int[10][10];
	
	/*
	 * 재귀 + 메모이제이션
	 * nCr = n! / (n-r)!r! 이다.
	 * nCr = n-1Cr-1 + n-1Cr 재귀로 계산하시오.
	 * 나를 포함하여 뽑은 경우 + 나를 포함하지 않고 뽑은 경우
	 */
	static int combi(int n, int r) {
		if(dy[n][r] > 0) return dy[n][r];
		if(r == 0 || n == r) return dy[n][r] = 1;
		else return dy[n][r] = combi(n-1, r-1) + combi(n-1, r);
	}
	
	static void DFS(int L) {
		if(flag) return;
		
		//순열 배열의 N개의 요소의 합이 F가 되는지 확인 
		if( L == N ) {
			int sum = 0;
			
			//공식사용 계산을 위한 조합 계산
			for(int i=0; i<N; i++) {
				sum += arr[i] * combi(N-1, i);
			}
			
			if ( sum == F ) {
				for(int i : arr) System.out.print(i + " ");
				flag = true;
			}
		} else {
			//순열 구하기
			for(int i=0; i<N; i++) {
				if(!visited[i]) {
					visited[i] = true;
					arr[L] = i+1;
					DFS(L+1);
					visited[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //윗줄 N
		F = sc.nextInt(); //가장 밑 숫자
		arr = new int[N];
		visited = new boolean[N];
		
		DFS(0);
	}

}
