package infl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ��¥: 2021/08/03
 * ����: ������ String 01-02 ��ҹ��� ��ȯ
 */
public class String_01_02 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String str2 = "";
		
		for(char c : str.toCharArray()) {
			if(Character.isUpperCase(c)) { // if ( c >= 'a' && ch <= 'z')
				str2 += Character.toLowerCase(c);
			} else if(Character.isLowerCase(c)){ // if ( c >= 'A' && c <= 'Z')
				str2 += Character.toUpperCase(c);
			} else {
				str2 += c;
			}
		}
		
		System.out.println(str2);
	}

}
