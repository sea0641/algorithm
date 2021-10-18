package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/09/27
 * ����: ������ TwoPointers 03-04 ���� �κм���
 */

public class TwoPointers_03_04_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //n���� ��
		int m = sc.nextInt(); //������ ��
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
