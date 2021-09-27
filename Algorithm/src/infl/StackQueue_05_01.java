package infl;

import java.util.Scanner;
import java.util.Stack;

/*
 * ��¥: 2021/08/09
 * ����: ������ StackQueue 05-01 �ùٸ� ��ȣ
 */

public class StackQueue_05_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		Stack<Character> stack = new Stack<Character>();
		String answer = "YES";
		for(char c : str.toCharArray()) {
			if( c == '(' ) stack.push(c);
			else {
				if(stack.isEmpty())  {
					answer = "NO";
					break;
				} else {
					stack.pop();
				}
			}
		}
		
		if(!stack.isEmpty()) answer = "NO";
		
		System.out.println(answer);
	}

}
