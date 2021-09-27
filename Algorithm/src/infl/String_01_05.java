package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜: 2021/08/03
 * 문제: 인프런 String 01-05 특정 문자 뒤집기
 */

public class String_01_05 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringBuilder sb = new StringBuilder(str);
		
		int st = 0;
		int end = str.length()-1;
		while(st < end) {
			char c1 = str.charAt(st);
			char c2 = str.charAt(end);
			if(Character.isLetter(c1)) {
				if(Character.isLetter(c2)) {
					sb.setCharAt(st, c2); 
					sb.setCharAt(end, c1);
					st++;
					end--;
				} else {
					end--;
				}
				
			} else {
				st++;
			}
		}
		
		System.out.println(sb.toString());
	}

}
