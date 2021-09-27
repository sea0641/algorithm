package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/04
 * 문제: 인프런 String 01-07 회문 문자열
 */

public class String_01_07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();

		StringBuilder sb = new StringBuilder(str).reverse();
		
		System.out.println(str.equalsIgnoreCase(sb.toString()) ? "YES" : "NO");
	}

}
