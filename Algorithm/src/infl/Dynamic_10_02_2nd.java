package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/11/11
 * ����: ������ ������ȹ�� 10-02 ���ٸ� �ǳʱ�
 */

public class Dynamic_10_02_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //��� ��
		int[] dy = new int[n+1];
		
		dy[1] = 1; //1��° ��� ������ ����� ��
		dy[2] = 2; //2��° ��� ������ ����̤� ��
		for(int i=3; i<=n+1; i++) {
			dy[i] = dy[i-2] + dy[i-1];
		}
		
		System.out.println(dy[n+1]);
	}

}
