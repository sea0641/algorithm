package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/11/03
 * ����: ������ DFSBFS���� 07-04 �Ǻ���ġ ���(�޸������̼�)
 */

/*
 * ����: n�� ���� �Ǻ���ġ ���� ���
 * 1) nũ���� �迭, 1 1 �ʱ�ȭ
 * 2) n�Է½� DFS�� ���� �μ� ���ؼ� �����ϰ� ����
 * 3) �޸������̼�: �̹� �˰��ִ� �����̸� �ٷ� ����
 * ��� < for ����Լ��� ���������ӱ���̶� ����&�޸� ���� ������
 */
public class DfsBfsB_07_04_2nd {
	static int[] fibo;
	
	public static int DFS(int n) {
		//�޸����̼�
		if(fibo[n] > 0) return fibo[n];
		
		if( n <= 1 ) return fibo[n] = 1;
		else {
			return fibo[n] = DFS(n-2) + DFS(n-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		fibo = new int[n];
		
		/*
		DFS(n-1);
		for(int i : fibo) System.out.print(i + " ");
		*/
		
		for(int i=0; i<n; i++) {
			if( i <= 1 ) fibo[i] = 1;
			else {
				fibo[i] = fibo[i-2] + fibo[i-1];
			}
			System.out.print(fibo[i] + " ");
		}
	}

}
