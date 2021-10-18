package infl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackQueue_05_07_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String need = sc.nextLine();
		
		String answer = "YES";
		Queue<Character> qu = new LinkedList<Character>();
		for(char c : need.toCharArray()) qu.offer(c);
		for(char c : sc.nextLine().toCharArray()) {
			if(qu.contains(c)) {
				if(c != qu.poll()) {
					answer = "NO";
					break;
				}
			}
		}
		
		if(!qu.isEmpty()) answer = "NO";
		
		System.out.println(answer);
	}

}
