package infl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackQueue_05_06_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Queue<Integer> qu = new LinkedList<Integer>();
		for(int i=1; i<=n; i++) qu.add(i);
		
		int count = 0;
		while(qu.size() > 1) {
			count++;
			if(count % 3 == 0) qu.poll();
			else qu.offer(qu.poll());
		}
		
		System.out.println(qu.peek());
	}

}
