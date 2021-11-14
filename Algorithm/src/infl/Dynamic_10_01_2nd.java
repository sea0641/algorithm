package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/11/11
 * 문제: 인프런 동적계획법 10-01 계단오르기
 */

/*
 * 계단 3번째 오르는 경우의 수(1번째 계단 + 2칸, 2번째 계단 + 1칸):
 * 1번째 계딴오르는 경우의 수 + 2번째 계단 오르는 경우의 수
 */
public class Dynamic_10_01_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //계단 수
		int[] dy = new int[n+1];
		
		dy[1] = 1; //1번째 계단 오르는 경우의 수
		dy[2] = 2; //2번째 계단 오르는 경우이ㅡ 수
		for(int i=3; i<=n; i++) {
			dy[i] = dy[i-2] + dy[i-1];
		}
		
		System.out.println(dy[n]);
	}

}
