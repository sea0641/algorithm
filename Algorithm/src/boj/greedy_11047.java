package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 날짜: 2021/04/22
 * 문제: 백준 알고리즘 11047번_동전 0
 * 설명: 그리디
 */

public class greedy_11047 {
	static int n; //동전 개수
	static int k; //필요 금액
	static int[] coins; //동전 가치 배열
	static int minCoin = 0; //필요한 최소 동전 수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		coins = new int[n];
		
		for(int i=0; i<n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=n-1; i>=0; i--) {
			if(coins[i] <= k) {
				minCoin += k/coins[i];
				k = k%coins[i];
			} else if(k == 0) {
				break;
			}
		}
		
		System.out.println(minCoin);
	}

}
