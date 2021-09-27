package infl;

import java.util.Scanner;

/*
 * ��¥: 2021/08/04
 * ����: ������ String 01-11 ���ڿ� ����
 */

public class String_01_11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		StringBuilder sb = new StringBuilder();

		int cnt = 1;
		for(int i=0; i<str.length(); i++) {
			if(i+1 <= str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
				cnt++;
			} else {
				sb.append(str.charAt(i));
				if(cnt > 1) sb.append(cnt);
				cnt = 1;
			}
		}

		
		System.out.println(sb.toString());
	}

}
