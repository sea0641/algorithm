package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/09/27
 * 문제: 인프런 TwoPointers 03-06 최대 길이 연속부분수열
 */

public class TwoPointers_03_06_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = sc.nextInt();
		
		int answer = 0, cnt = 0, lt=0;
		for(int rt=0; rt<n; rt++) {
			if ( arr[rt] == 0 ) cnt++;
			
			while ( cnt > k ) {
				if(arr[lt] == 0) cnt--;
				lt++;
			}
			
			if (cnt == k) answer = Math.max(answer, rt-lt+1);
		}
		
		System.out.println(answer);
	}

}
