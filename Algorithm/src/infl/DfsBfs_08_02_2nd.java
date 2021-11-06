package infl;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * 날짜: 2021/11/06
 * 문제: 인프런 DFSBFS 08-02 바둑이 승차(DFS)
 */

/*
 * 트럭은 C킬로그램 넘게 태울 수 없다. 바둑이 N마리 중 가장 무겁게 태울 때 무게는?
 * 한 배열의 부분집합 DFS
 * 바둑이 무게 내림차순 후, C를 안넘는 무게 구한 뒤 max 교체
 */
public class DfsBfs_08_02_2nd {
	static int C,N;
	static Integer[] arr;
	static int answer = 0;
	
	static void DFS(int L, int sum) {
		//C 무게 넘으면 불가능 케이스 return;
		if( sum > C) return;
		
		if( L == N ) {
			//C보다 작은 합의 해당 부분집합들 중 가장 무거운 값 구하기
			answer = Math.max(answer, sum);
		} else {
			DFS(L+1, sum + arr[L]);
			DFS(L+1, sum);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		C = sc.nextInt(); //트럭 최대 무게
		N = sc.nextInt(); //바둑이 마리수
		 arr = new Integer[N]; //바둑이 무게들
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		DFS(0, 0);
		
		System.out.println(answer);
	}

}
