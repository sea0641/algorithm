package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/06
 * 문제: 인프런 TwoPointers 03-04 연속 부분수열
 */

public class TwoPointers_03_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int answer = 0;
		/*
		for(int i=0; i<n; i++) {
			int sum = 0;
			int p = i;
			while(sum < m && p<n) {
				sum += arr[p++];
			}
			if(sum == m) answer++;
		}*/
		int lt = 0;
		int sum = 0;
		for(int rt=0; rt<n; rt++) {
			sum += arr[rt];
			
			if(sum == m) answer++;
			
			while(sum >= m) {
				sum -= arr[lt++];
				if(sum == m) answer++;
			}
		}
		System.out.println(answer);
	}

}
