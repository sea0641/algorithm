package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/05
 * 문제: 인프런 Array 02-10 봉우리
 */

public class Array_02_10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[][] = new int[n+2][n+2];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int cnt = 0;
		boolean b;
		int[] dx = {0, 0, -1, 1};
		int[] dy = {-1, 1, 0, 0};
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				b = true;
				for(int k=0; k<4; k++) {
					if(arr[i][j] <= arr[i+dx[k]][j+dy[k]]) {
						b = false;
						break;
					}
				}
				
				if(b) cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
