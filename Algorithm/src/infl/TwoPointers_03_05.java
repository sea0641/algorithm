package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/07
 * ����: ������ TwoPointers 03-05 ���ӵ� �ڿ����� ��
 */

public class TwoPointers_03_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int answer = 0;
		
		// 1. ���Ļ��_i~j������ ���ӵ� ������ ��
		for(int i=1; i<=n/2; i++) {
			for(int j=i+1; j<=n/2+1; j++) {
				int sum = j * (j+1) / 2 - (i-1) * i / 2;
				if( sum == n ) {
					answer++;
					break;
				}
			}
		}
		
		// 2. two pointers ���
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
		
		// 3-1. ���� ��� �� �ڸ������� 1���� ���ӵ� ���ڸ� �Ҵ��ϰ�, ���� ���ڰ� �յ��ϰ� �й�Ǿ�� �Ѵ�.
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
