package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/09/27
 * 문제: 인프런 TwoPointers 03-04 연속 부분수열
 */

public class TwoPointers_03_04_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //n개의 수
		int m = sc.nextInt(); //숫자의 합
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		int cnt = 0;
		int sum = 0;
		int lt=0;
		for(int rt=0; rt<n; rt++) {
			sum += arr[rt];
			
			if(sum == m) cnt++;
			
			while(sum >= m) {
				sum -= arr[lt++];
				if(sum == m) cnt++;
			}
			
		}
		
		System.out.println(cnt);

	}

}
