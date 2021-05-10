package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ��¥: 2021/05/10
 * ����: ���� �˰��� 1182��_�κм���
 * ����: DP, DFS
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
		
		dfs(i+1, sum); //�ڱ� �ڽ��� �ȴ��� ��
		dfs(i+1, sum+arr[i]); //�ڱ� �ڽ��� ���� ��
	}

}
