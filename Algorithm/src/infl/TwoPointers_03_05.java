package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/07
 * 문제: 인프런 TwoPointers 03-05 연속된 자연수의 합
 */

public class TwoPointers_03_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int answer = 0;
		
		// 1. 공식사용_i~j까지의 연속된 숫자의 합
		for(int i=1; i<=n/2; i++) {
			for(int j=i+1; j<=n/2+1; j++) {
				int sum = j * (j+1) / 2 - (i-1) * i / 2;
				if( sum == n ) {
					answer++;
					break;
				}
			}
		}
		
		// 2. two pointers 사용
		int sum = 0;
		int lt = 0;
		int m = n/2+1;
		int[] arr = new int[m];
		for(int i=0; i<m; i++) arr[i] = i+1;
		for(int rt=0; rt<m; rt++) {
			sum += arr[rt];
			
			if(sum == n) answer++;
			
			while(sum >= n) {
				sum -= arr[lt++];
				if(sum == n) answer++;
			}
		}
		
		// 3-1. 수학 사용 각 자릿수마다 1부터 연속된 숫자를 할당하고, 남은 숫자가 균등하게 분배되어야 한다.
		for(int i=2; i<=n/2; i++) {
			int tmp = i * (i+1) / 2;
			if(tmp > n) continue;
			int rest = n - tmp;
			if(rest % i == 0) answer++;
		}
		// 3-2.
		int cnt = 1;
		n--;
		while(n>0) {
			cnt++;
			n -= cnt;
			if(n % cnt == 0) answer++;
		}
		
		System.out.println(answer);
	}

}
