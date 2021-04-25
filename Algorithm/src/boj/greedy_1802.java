package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 날짜: 2021/04/24
 * 문제: 백준 알고리즘 1802번_종이접고
 * 설명: 그리디_대칭활용
 */

public class greedy_1802 {
	static final String YES = "YES";
	static final String NO = "NO";
	static String[] papers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); //테스트케이스 개수
		papers = new String[t];
		for(int i=0; i<t; i++) {
			papers[i] = br.readLine();
		}
		
		for(String s : papers) {
			if(divNCon(s)) {
				System.out.println(YES);
			} else {
				System.out.println(NO);
			}
		}
	}
	
	//분할정복 사용
	public static boolean divNCon(String str) {
		if(str.length()==1) {
			return true;
		}
		int mid = str.length()/2;
		
		for(int i = 0 ; i < mid ; i++) {
			if(str.charAt(i) == str.charAt(str.length()-1-i)) {
				return false;
			}
		}
		return divNCon(str.substring(0,mid));
	}
	
	public static boolean foldingPapger(String p) {
		boolean result = false;
		int len = p.length();
		//한번만 접은건 무조건 다시 접을 수 있다.
		if(len == 1) {
			result = true;
			return result;
		}

		int center = len / 2;
		int leftP;
		int rightP;
		while(center > 0) {
			for(int i=1; i<=center; i++) {
				leftP = p.charAt(center-i) - '0';
				rightP = p.charAt(center+i) - '0';
				if(leftP + rightP == 1) {
					result = true;
				} else {
					result = false;
					return result;
				}
			}
			
			center /= 2;
		}

		return result;
	}

}
