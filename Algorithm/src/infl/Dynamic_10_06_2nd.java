package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/11/12
 * 문제: 인프런 동적계획법 10-06 최대점수 구하기(냅색 알고리즘)
 */

public class Dynamic_10_06_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //문제의 개수
		int m = sc.nextInt(); //제한시간
		//각 분별로 풀 수 있는 최대 점수
		int[] dy = new int[m+1];
		for(int i=0; i<n; i++) {
			int ps = sc.nextInt(); //풀었을 때 점수
			int pt = sc.nextInt(); //소요시간
			for(int j=m; j>=pt; j--) { //자원 한정적이기 때문에 뒤에서부터 시작
				dy[j] = Math.max(dy[j], dy[j-pt] + ps);
			}
		}
		
		System.out.println(dy[m]);
	}

}
