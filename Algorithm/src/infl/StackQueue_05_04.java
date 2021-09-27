package infl;

import java.util.Scanner;
import java.util.Stack;

/*
 * 날짜: 2021/08/09
 * 문제: 인프런 StackQueue 05-04 후위식 연산(postfix)
 */

public class StackQueue_05_04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		Stack<Integer> stack = new Stack<Integer>();
		for(char c : str.toCharArray()) {
			if(Character.isDigit(c)) {
				stack.push(Character.getNumericValue(c));
			} else {
				int b = stack.pop();
				int a = stack.pop();
				int rslt = 0;
				switch(c) {
					case '+':
						rslt = a + b;
						break;
					case '-':
						rslt = a - b;
						break;
					case '*':
						rslt = a * b;
						break;
					case '/':
						rslt = a / b;
						break;
					default:
				}
				stack.push(rslt);
			}
		}
		
		System.out.println(stack.pop());
	}
}
