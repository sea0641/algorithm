package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/09/17
 * 문제: 인프런 동적계획법 10-02 돌다리 건너기
 */

public class Dynamic_10_02 {
	static int[] dy;
	
	static int solution(int n) {
		dy[1] = 1;
		dy[2] = 2;
		for(int i=3; i<=n+1; i++) {
			dy[i] = dy[i-2] + dy[i-1];
		}
		return dy[n+1];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dy = new int[n+2];
		
		System.out.println(solution(n));
	}

}
