package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/06
 * ����: ������ TwoPointers 03-03 �ִ� ����
 */

public class TwoPointers_03_03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int amt = 0;
		int tmp = 0;
		for(int i=0; i<k; i++) {
			tmp += arr[i];
		}
		amt = tmp;
		for(int i=0; i<n-k; i++) {
			/* �ð� �ʰ�
			int tmp = 0;
			for(int j=0; j<k;j++) {
				tmp += arr[i+j];
			}
			*/
			
			tmp = tmp + arr[i+k] - arr[i];
			amt = Math.max(amt, tmp);
		}
		
		System.out.println(amt);
	}

}
