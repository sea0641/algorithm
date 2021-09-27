package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/07
 * ����: ������ TwoPointers 03-06 �ִ� ���� ���Ӻκм���
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
			
			// 1 -> 0, k�� �ʰ��Ͽ� �ٲ��� ���
			while(cnt > k) {
				if(arr[lt] == 0) cnt--;
				lt++;
			}
			//1�� ���� ī����
			answer = Math.max(answer, rt - lt + 1);
		}
		
		System.out.println(answer);
	}

}
