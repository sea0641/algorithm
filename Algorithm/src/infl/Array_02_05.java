package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/05
 * ����: ������ Array 02-05 �Ҽ�(�����佺�׳׽� ü)
 */

public class Array_02_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int cnt = 0;
		int[] arr = new int[n+1];
		
		for(int i=2; i<=n; i++) {
			if(arr[i] == 0) {
				cnt++;
				for(int j=i; j<=n; j=j+i) arr[j] = 1;
			}
		}
		
		System.out.println(cnt);

	}

}
