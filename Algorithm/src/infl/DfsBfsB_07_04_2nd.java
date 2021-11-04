package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/11/03
 * 문제: 인프런 DFSBFS기초 07-04 피보나치 재귀(메모이제이션)
 */

/*
 * 문제: n개 항의 피보나치 수열 출력
 * 1) n크기의 배열, 1 1 초기화
 * 2) n입력시 DFS로 앞의 두수 더해서 저장하고 리턴
 * 3) 메모이제이션: 이미 알고있는 숫자이면 바로 리턴
 * 재귀 < for 재귀함수는 스택프레임기반이라 성능&메모리 측면 안좋음
 */
public class DfsBfsB_07_04_2nd {
	static int[] fibo;
	
	public static int DFS(int n) {
		//메모제이션
		if(fibo[n] > 0) return fibo[n];
		
		if( n <= 1 ) return fibo[n] = 1;
		else {
			return fibo[n] = DFS(n-2) + DFS(n-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		fibo = new int[n];
		
		/*
		DFS(n-1);
		for(int i : fibo) System.out.print(i + " ");
		*/
		
		for(int i=0; i<n; i++) {
			if( i <= 1 ) fibo[i] = 1;
			else {
				fibo[i] = fibo[i-2] + fibo[i-1];
			}
			System.out.print(fibo[i] + " ");
		}
	}

}
