package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/04
 * 문제: 인프런 String 01-08 유효한 팰린드롬
 */

public class String_01_08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		str = str.toLowerCase().replaceAll("[^a-z]", "");

		System.out.println(str.equals(new StringBuilder(str).reverse().toString()) ? "YES" : "NO");
	}

}
