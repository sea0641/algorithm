package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜: 2021/08/03
 * 문제: 인프런 String 01-03 문장 속 단어
 */

public class String_01_03 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] arr = br.readLine().split(" ");
		String rslt = "";
		for(String str : arr) {
			if(rslt.length() < str.length()) rslt = str;
		}
		
		System.out.println(rslt);
	}

}
