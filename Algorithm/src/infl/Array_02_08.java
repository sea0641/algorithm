package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/05
 * 문제: 인프런 Array 02-08 등수구하기
 */

public class Array_02_08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			int cnt = 1;
			for(int j=0; j<n; j++) {
				if(arr[i] < arr[j]) {
					cnt++;
				}
			}
			System.out.print(cnt + " ");
		}

	}

}
