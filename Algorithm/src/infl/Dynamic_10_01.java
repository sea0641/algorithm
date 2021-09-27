package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/09/17
 * 문제: 인프런 동적계획법 10-01 계단오르기
 */

public class Dynamic_10_01 {
	static int[] dy;
	
	public static int solution(int n) {
		dy[1] = 1; //1계단까지 오르는 경우의 수
		dy[2] = 2; //2계단까지 오르는 경우의 수
		for(int i=3; i<=n; i++) {
			dy[i] = dy[i-2] + dy[i-1]; //i까지 오르는 경우의 수는 이전 두계단의 경우의 수 합(피보나치)
		}
		
		return dy[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dy = new int[n+1];
		System.out.println(solution(n));
	}

}
