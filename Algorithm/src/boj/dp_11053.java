package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 날짜: 2021/05/21
 * 문제: 백준 알고리즘 11053번_가장 긴 증가하는 부분 수열
 * 설명: https://developer-mac.tistory.com/71
 */

public class dp_11053 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = stoi(br.readLine());
		int arr[] = new int[n+1];
		int dp[] = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = stoi(st.nextToken());
		}
		
		dp[1] = 1;
		for(int i=2; i<=n; i++) {
			dp[i] = 1;
			
			for(int j=1; j<i; j++) {
				if(arr[i] > arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		System.out.println(Arrays.stream(dp).max().getAsInt());
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}

}
