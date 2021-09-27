package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜: 2021/08/03
 * 문제: 인프런 String 01-04 단어 뒤집기
 */

public class String_01_04 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];
		for(int i=0; i<n; i++) {
			arr[i] = br.readLine();
		}
		
		StringBuilder sb;
		for(String str : arr) {
			sb = new StringBuilder(str);
			sb.reverse();
			System.out.println(sb.toString());
		}
	}

}
