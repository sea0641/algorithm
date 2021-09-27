package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/05
 * 문제: 인프런 Array 02-12 멘토링
 */

public class Array_02_12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); //학생 수 
		int m = sc.nextInt(); //테스트 개수
		int[][] arr = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int answer = 0;
		//멘토 번호
		for(int i=1; i<=n; i++) {
			//멘티 번호
			for(int j=1; j<=n; j++) {
				int cnt = 0;
				//모든 테스트 확인
				for(int k=0; k<m; k++) {
					int pi=0, pj=0;
					//등수 확인, 비교
					for(int s=0; s<n; s++) {
						if(arr[k][s] == i) pi = s;
						if(arr[k][s] == j) pj = s;
					}
					
					if(pi<pj) cnt++;
				}
				
				if(cnt == m) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}

}
