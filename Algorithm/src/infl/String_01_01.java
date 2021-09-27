package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 날짜: 2021/08/03
 * 문제: 인프런 String 01-01 문자 찾기
 */	

public class String_01_01 {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    String str = br.readLine().toLowerCase();
	    char c = Character.toLowerCase(br.readLine().charAt(0));
	    int cnt = 0;
	    
	    for ( int i=0; i<str.length(); i++ ) {
	    	if ( str.charAt(i) == c ) cnt++;
	    }
	    /* for-each 사용
	     * for(char ch : str.toCharArray()) {
	     * 	if ( ch == c ) cnt++;
	     * }
	     */
	    
	    System.out.println(cnt);
	  }
}
