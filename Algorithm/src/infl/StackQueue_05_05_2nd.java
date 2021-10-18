package infl;

import java.util.Scanner;
import java.util.Stack;

public class StackQueue_05_05_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Stack<Character> stack = new Stack<>();
		int cnt = 0;
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			
			if( ch == '(') stack.push(ch);
			else {
				char prev = str.charAt(i-1);
				stack.pop();
				if( prev == '(') { //·¹ÀÌÀú
					cnt += stack.size();
				} else {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
