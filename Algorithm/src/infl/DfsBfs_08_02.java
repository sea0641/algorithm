package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/29
 * 문제: 인프런 DFSBFS 08-02 바둑이 승차(DFS)
 */

public class DfsBfs_08_02 {
	static int C;
	static int N;
	static int w;
	static int[] arr;
	
	public static void DFS(int L, int sum) {
		if(sum > C ) return;
		
		if(L == N) w = Math.max(w, sum);
		else {
			DFS(L+1, sum + arr[L]);
			DFS(L+1, sum);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		C = sc.nextInt(); //트럭의 최대 킬로그램
		N = sc.nextInt(); // 바둑이 수
		arr = new int[N]; // 바둑이 무게
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		DFS(0, 0);
		
		System.out.println(w);
	}

}
