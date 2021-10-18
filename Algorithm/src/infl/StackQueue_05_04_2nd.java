package infl;

import java.util.Scanner;
import java.util.Stack;

public class StackQueue_05_04_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		for(char c : sc.nextLine().toCharArray()) {
			if(Character.isDigit(c)) stack.push(Character.getNumericValue(c));
			else {
				int b = stack.pop();
				int a = stack.pop();
				switch(c) {
					case '+':
						stack.push(a+b);
						break;
					case '-':
						stack.push(a-b);
						break;
					case '*':
						stack.push(a*b);
						break;
					case '/':
						stack.push(a/b);
						break;
					default:
				}
			}
		}
		
		System.out.println(stack.pop());
	}

}
