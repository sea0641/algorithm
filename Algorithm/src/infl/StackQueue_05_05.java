package infl;

import java.util.Scanner;
import java.util.Stack;

/*
 * ��¥: 2021/08/09
 * ����: ������ StackQueue 05-05 �踷���
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
				
				//�������� Ȯ��
				char c = str.charAt(i-1);
				
				if(c == '(') { //������
					answer += stack.size();
				} else { //����� ��
					answer++;
				}
				
			}
		}
		
		System.out.println(answer);
	}

}
