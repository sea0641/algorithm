package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/05
 * ����: ������ Array 02-11 �ӽù��� ���ϱ�
 */

public class Array_02_11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n+1][6];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=5; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		int student = 0;
		int max = Integer.MIN_VALUE;
		//�� �л����� ������ �� ����
		for(int i=1; i<=n; i++) {
			int cnt = 0;
			//�ش� �л��� ������ �л����� ������ ��
			for(int j=1; j<=n; j++) {
				//�� �л��� �г⺰ ��
				for(int k=1; k<=5; k++) {
					if(arr[i][k] == arr[j][k] && i != j) {
						cnt++;
						break;
					}
				}
			}
			
			if(max < cnt) {
				student = i;
				max = cnt;
			}
		}
		
		System.out.println(student);
	}

}
