package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/05
 * ����: ������ Array 02-04 �Ǻ���ġ ����
 */

public class Array_02_04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[n];
		arr[0] = 1;
		arr[1] = 1;
		
		for(int i=0; i<n; i++) {
			if(i>=2) {
				arr[i] = arr[i-1] + arr[i-2];
			}
			
			System.out.print(arr[i] + " ");
			
		}
	}

}
