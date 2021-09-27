package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/07
 * 문제: 인프런 TwoPointers 03-06 최대 길이 연속부분수열
 */

public class TwoPointers_03_06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int answer = 0, cnt = 0, lt = 0;
		for(int rt=0; rt<n; rt++) {
			// 0 -> 1
			if(arr[rt] == 0) cnt++;
			
			// 1 -> 0, k번 초과하여 바꿨을 경우
			while(cnt > k) {
				if(arr[lt] == 0) cnt--;
				lt++;
			}
			//1의 개수 카운팅
			answer = Math.max(answer, rt - lt + 1);
		}
		
		System.out.println(answer);
	}

}
