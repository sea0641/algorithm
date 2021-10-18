package infl;

import java.util.Scanner;
import java.util.Stack;

/*
 * ��¥: 2021/10/13
 * ����: ������ StackQueue 05-02 ��ȣ��������
 */

public class StackQueue_05_02_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Stack<Character> stack = new Stack<>();
		for(char c : sc.nextLine().toCharArray()) {
			if(c == ')') while(stack.pop() != '(');
			else stack.push(c);
		}
		
		for(char c : stack) System.out.print(c);
	}

}
