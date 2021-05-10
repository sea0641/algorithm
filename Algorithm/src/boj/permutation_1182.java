package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 날짜: 2021/05/10
 * 문제: 백준 알고리즘 1182번_부분순열
 * 설명: DP, DFS
 * https://sihyungyou.github.io/baekjoon-1182/
 */

public class permutation_1182 {
	static int n;
	static int s;
	static int[] arr;
	static int cnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = stoi(st.nextToken());
		s = stoi(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = stoi(st.nextToken());
		}
		
		dfs(0, 0);
		
		System.out.println(cnt);
		
	}
	
	public static int stoi(String str) {
		return Integer.parseInt(str);
	}
	
	public static void dfs(int i, int sum) {
		if(i == n) return;
		if(sum + arr[i] == s) cnt++;
		
		dfs(i+1, sum); //자기 자신을 안더한 것
		dfs(i+1, sum+arr[i]); //자기 자신을 더한 것
	}

}
