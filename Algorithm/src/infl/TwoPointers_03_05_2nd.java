package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/09/27
 * 문제: 인프런 TwoPointers 03-05 연속된 자연수의 합
 */

public class TwoPointers_03_05_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int m = n/2+1;
		int[] arr = new int[m];
		for(int i=0; i<m; i++) arr[i] = i+1;
		
		int lt=0;
		int sum=0;
		int cnt=0;
		for(int rt=0; rt<m; rt++) {
			sum += arr[rt];
			
			if(sum == n) cnt++;
			
			while(sum >= n) {
				sum -= arr[lt++];
				if(sum == n) cnt++;
			}
		}
		
		System.out.println(cnt);
	}

}
