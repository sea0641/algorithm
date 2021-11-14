package infl;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ��¥: 2021/11/11
 * ����: ������ ������ȹ�� 10-03 �ִ�κ���������(LIS)
 */

public class Dynamic_10_03_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		
		//�� index������ �� �� �ִ� ���� �� ���� ��
		int[] dy = new int[N];
		dy[0] = 1;
		
		for(int i=1; i<N; i++) {
			//�̷� ������ ������ 0 �ʱ�ȭ
			int max = 0;
			
			//���� ���� �� ������ �� �� �ִ� ���� �� ���� �� ã��
			for(int j=i-1; j>=0; j--) {
				if(arr[i] > arr[j]) {
					max = Math.max(max, dy[j]);
				}
			}
			
			//���� �̷� ���� + 1
			dy[i] = max + 1;
		}

		System.out.println(Arrays.stream(dy).max().getAsInt());
	}

}
