package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/04
 * ����: ������ String 01-07 ȸ�� ���ڿ�
 */

public class String_01_07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		StringBuilder sb = new StringBuilder(str).reverse();
		
		System.out.println(str.equalsIgnoreCase(sb.toString()) ? "YES" : "NO");
	}

}
