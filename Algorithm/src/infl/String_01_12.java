package infl;

import java.util.Scanner;

/*
 * 날짜: 2021/08/04
 * 문제: 인프런 String 01-12 암호
 */

public class String_01_12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int len = sc.nextInt();
		String str = sc.next();
		StringBuilder answer = new StringBuilder();
		for(int i=0; i<len; i++) {
			String two = str.substring(0, 7).replace('#', '1').replace('*', '0');
			
			char c1 = (char)Integer.parseInt(two, 2); //2진수 -> 10진수 변환
			answer.append(c1);
			
			str = str.substring(7);
		}
		/*
		StringBuilder answer = new StringBuilder();
		for(String le : letter) {
			StringBuilder two = new StringBuilder();
			for(char c : le.toCharArray()) {
				if(c == '#') two.append("1");
				else if (c == '*') two.append("0");
			}
			char c1 = (char)Integer.parseInt(two.toString(), 2); //2진수 -> 10진수 변환
			answer.append(c1);
		}
		*/
		System.out.println(answer.toString());
	}

}
