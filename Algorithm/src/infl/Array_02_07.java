package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 날짜: 2021/08/05
 * 문제: 인프런 Array 02-07 점수계산
 */

public class Array_02_07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int[] score = new int[n];
		score[0] = arr[0];
		for(int i=1; i<n; i++) {
			if(arr[i] == 0) {
				continue;
			} else {
				if(arr[i-1] == 0) score[i] = 1;
				else score[i] = score[i-1] + 1;
			}
		}
		/*
		 * 점수배열 안만들고 합계 구하기
		 * int answer = 0;
		 * int cnt = 0;
		 * for(int i=0; i<n; i++) {
		 * 	if(arr[i] == 1) {
		 * 		cnt++;
		 * 		answer += cnt;
		 * 	} else {
		 * 		cnt = 0;
		 * 	}
		 * }
		 */
		
		
		System.out.println(Arrays.stream(score).sum());
	}

}
