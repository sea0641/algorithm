package infl;

import java.util.Scanner;
import java.util.Stack;

/*
 * 날짜: 2021/08/09
 * 문제: 인프런 StackQueue 05-02 괄호문자제거
 */

public class StackQueue_05_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		Stack<Character> stack = new Stack<Character>();
		for(Character ch : str.toCharArray()) {
			if(ch != ')') {
				stack.push(ch);
			} else {
				while(stack.pop() != '(');
			}
		}
		
		for(char ch : stack) {
			System.out.print(ch);
		}
	}

}
