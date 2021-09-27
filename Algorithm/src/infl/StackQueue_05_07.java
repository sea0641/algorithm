package infl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * ��¥: 2021/08/09
 * ����: ������ StackQueue 05-07 �������� ����
 */

public class StackQueue_05_07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String essential = sc.nextLine();
		String classes = sc.nextLine();
		
		Queue<Character> qu = new LinkedList<Character>();
		for(char ch : classes.toCharArray()) {
			qu.offer(ch);
		}
		
		int idx = 0;
		String answer = "NO";
		while(!qu.isEmpty()) {
			if(idx == essential.length()) {
				answer = "YES";
				break;
			}
			char ch = essential.charAt(idx);
			char clas = qu.poll();
			
			if(clas == ch) idx++;
		}
		
		/* �ʼ������� queue�� ������� ���
		Queue<Character> qu = new LinkedList<Character>();
		for(char ch : essential.toCharArray()) {
			qu.offer(ch);
		}
		
		String answer = "YES";
		for(char ch : classes.toCharArray()) {
			if(qu.contains(ch)) {
				if(ch != qu.poll()) {
					answer = "NO";
					break;
				}
			}
		}
		
		if(!qu.isEmpty()) answer = "NO";
		*/
		
		System.out.println(answer);
	}

} 
