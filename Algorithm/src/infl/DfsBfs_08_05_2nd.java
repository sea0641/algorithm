package infl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * 날짜: 2021/11/06
 * 문제: 인프런 DFSBFS 08-05 동전교환
 */

public class DfsBfs_08_05_2nd {
	
	static int N,M;
	static Integer[] arr;
	static int answer = Integer.MAX_VALUE;
	
	static void DFS(int L, int sum) {
		
		if (sum > M) return;
		//시간초과 방지, 이미 최소 개수를 넘어가면 볼 필요 없다.
		if( L > answer ) return;
		
		if ( sum == M ) {
			answer = Math.min(L, answer);
		} else {
			for(int i : arr) {
				DFS(L+1, sum + i);
			}
		}
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //동전 종류 개수
		arr = new Integer[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		M = sc.nextInt(); //거슬러줄 금액
		
		//시간초과나서 내림차순 정렬 수행
		Arrays.sort(arr, Collections.reverseOrder());
		DFS(0, 0);
		
		System.out.println(answer);
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0);
	}

}
