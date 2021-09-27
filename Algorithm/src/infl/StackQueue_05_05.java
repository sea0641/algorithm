package infl;

import java.util.Scanner;
import java.util.Stack;

/*
 * 날짜: 2021/08/09
 * 문제: 인프런 StackQueue 05-05 쇠막대기
 */

public class StackQueue_05_05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack<Character> stack = new Stack<Character>();
		int answer = 0;
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if(ch == '(') {
				stack.push(ch);
			} else {
				stack.pop();
				
				//이전문자 확인
				char c = str.charAt(i-1);
				
				if(c == '(') { //레이저
					answer += stack.size();
				} else { //막대기 끝
					answer++;
				}
				
			}
		}
		
		System.out.println(answer);
	}

}
