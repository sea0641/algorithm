package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/04
 * ����: ������ String 01-06 �ߺ���������
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
		 * indexOf ���
		 * for(int i=0; i<str.length(); i++) {
		 * 	if(str.indexOf(str.charAt(i)) == i) sb.append(str.charAt(i));
		 * }
		 */

		System.out.println(sb.toString());
	}

}
