package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/05
 * 문제: 인프런 Array 02-11 임시반장 정하기
 */

public class Array_02_11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+1][6];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int student = 0;
		int max = Integer.MIN_VALUE;
		//각 학생별로 같은반 수 세기
		for(int i=1; i<=n; i++) {
			int cnt = 0;
			//해당 학생과 나머지 학생들의 같은반 비교
			for(int j=1; j<=n; j++) {
				//두 학생의 학년별 비교
				for(int k=1; k<=5; k++) {
					if(arr[i][k] == arr[j][k] && i != j) {
						cnt++;
						break;
					}
				}
			}
			
			if(max < cnt) {
				student = i;
				max = cnt;
			}
		}
		
		System.out.println(student);
	}

}
