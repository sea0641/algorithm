package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * ��¥: 2021/08/03
 * ����: ������ String 01-01 ���� ã��
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
	    /* for-each ���
	     * for(char ch : str.toCharArray()) {
	     * 	if ( ch == c ) cnt++;
	     * }
	     */
	    
	    System.out.println(cnt);
	  }
}
