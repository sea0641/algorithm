package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/04
 * 문제: 인프런 String 01-09 숫자만 추출
 */

public class String_01_09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		str = str.replaceAll("[^0-9]", "");
		System.out.println(Integer.parseInt(str));
	}

}
