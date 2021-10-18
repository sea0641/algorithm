package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/09/27
 * 문제: 인프런 TwoPointers 03-03 최대 매출
 */

public class TwoPointers_03_03_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //일수
		int k = sc.nextInt(); //연속된 k일
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		int answer = Integer.MIN_VALUE;
		int sum = 0;
		for(int i=0; i<n; i++) {
			if(i<k) {
				sum += arr[i];
			} else {
				sum -= arr[i-k];
				sum += arr[i];
			}
			answer = Math.max(answer, sum);
		}
		
		System.out.println(answer);
		
	}

}
