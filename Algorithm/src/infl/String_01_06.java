package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/04
 * 문제: 인프런 String 01-06 중복문자제거
 */

public class String_01_06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(i == 0) {
				sb.append(c);
			} else {
				String str2 = sb.toString();
				if( !str2.contains(""+c)) {
					sb.append(c);
				}
			}
		}
		
		/*
		 * indexOf 사용
		 * for(int i=0; i<str.length(); i++) {
		 * 	if(str.indexOf(str.charAt(i)) == i) sb.append(str.charAt(i));
		 * }
		 */

		System.out.println(sb.toString());
	}

}
