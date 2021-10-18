package infl;

import java.util.Scanner;
import java.util.Stack;

/*
 * ��¥: 2021/10/13
 * ����: ������ StackQueue 05-01 �ùٸ� ��ȣ
 */

public class StackQueue_05_01_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String answer = "YES";
		Stack<Character> stack = new Stack<>();
		for(char c : sc.nextLine().toCharArray()) {
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
		
		if(stack.size() > 0) answer = "NO";
		
		System.out.println(answer);
	}

}
