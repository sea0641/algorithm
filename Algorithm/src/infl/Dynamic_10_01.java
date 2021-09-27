package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/09/17
 * ����: ������ ������ȹ�� 10-01 ��ܿ�����
 */

public class Dynamic_10_01 {
	static int[] dy;
	
	public static int solution(int n) {
		dy[1] = 1; //1��ܱ��� ������ ����� ��
		dy[2] = 2; //2��ܱ��� ������ ����� ��
		for(int i=3; i<=n; i++) {
			dy[i] = dy[i-2] + dy[i-1]; //i���� ������ ����� ���� ���� �ΰ���� ����� �� ��(�Ǻ���ġ)
		}
		
		return dy[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dy = new int[n+1];
		System.out.println(solution(n));
	}

}
