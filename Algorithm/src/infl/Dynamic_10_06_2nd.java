package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/11/12
 * ����: ������ ������ȹ�� 10-06 �ִ����� ���ϱ�(���� �˰���)
 */

public class Dynamic_10_06_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //������ ����
		int m = sc.nextInt(); //���ѽð�
		//�� �к��� Ǯ �� �ִ� �ִ� ����
		int[] dy = new int[m+1];
		for(int i=0; i<n; i++) {
			int ps = sc.nextInt(); //Ǯ���� �� ����
			int pt = sc.nextInt(); //�ҿ�ð�
			for(int j=m; j>=pt; j--) { //�ڿ� �������̱� ������ �ڿ������� ����
				dy[j] = Math.max(dy[j], dy[j-pt] + ps);
			}
		}
		
		System.out.println(dy[m]);
	}

}
