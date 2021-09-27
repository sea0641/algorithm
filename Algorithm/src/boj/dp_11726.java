package boj;

import java.util.Scanner;

/*
 * 날짜: 2021/05/21
 * 문제: 백준 알고리즘 11726번_2xn 타일링
 * 설명: 
 */

public class dp_11726 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[1001];

		dp[1] = 1;
		dp[2] = 2;
		//d[n] = d[n-1] + d[n-2]
		//이전 타일에 세로바 1개 추가 + 두단계 이전 타일에 가로바 2개 추가
		for( int i=3; i<=n; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		}
		
		System.out.println(dp[n]);
	}

}
