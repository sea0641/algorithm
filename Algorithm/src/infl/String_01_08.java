package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/04
 * ����: ������ String 01-08 ��ȿ�� �Ӹ����
 */

public class String_01_08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		str = str.toLowerCase().replaceAll("[^a-z]", "");

		System.out.println(str.equals(new StringBuilder(str).reverse().toString()) ? "YES" : "NO");
	}

}
