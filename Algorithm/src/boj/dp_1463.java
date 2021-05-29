package boj;

import java.util.Scanner;

/*
 * ��¥: 2021/05/21
 * ����: ���� �˰��� 1463��_1�� �����
 * ����: 
 */

public class dp_1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[1000001];
		arr[1] = 0;
		arr[2] = 1;
		arr[3] = 1;
		
		for(int i=4; i<=n; i++) {
			//��� 1. 1�� ����.
			arr[i] = arr[i-1] + 1;
			//��� 2. 3���� ������.
			if ( i%3 == 0 ) {
				arr[i] = Math.min(arr[i], arr[i/3] + 1);
			}
			//��� 3. 2�� ������.
			if ( i%2 == 0 ) {
				arr[i] = Math.min(arr[i], arr[i/2] + 1);
			}
			
		}
		
		System.out.println(arr[n]);
	}

}
