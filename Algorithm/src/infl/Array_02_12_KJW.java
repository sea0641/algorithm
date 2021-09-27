package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/05
 * 문제: 인프런 Array 02-12 멘토링
 */

public class Array_02_12_KJW {

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
		int[][] temp = new int[n+1][n+1];
		int answer = 0;
		
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ;j < n ;j++) {
				int now = arr[i][j];
				for(int k = j+1; k < n ; k++) {
					temp[now][arr[i][k]]++;
				}
			}
		}
		for(int i =0; i < n+1;i++) {
			for(int j = 0 ; j < n+1;j++) {
				if(temp[i][j]==m) answer++;
			}
		}
		System.out.println(answer);
	}

}
