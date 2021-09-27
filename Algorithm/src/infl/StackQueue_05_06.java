package infl;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * ��¥: 2021/08/09
 * ����: ������ StackQueue 05-06 ���� ���ϱ�
 */

public class StackQueue_05_06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Queue<Integer> qu = new LinkedList<Integer>();
		for(int i=1; i<=n; i++) {
			qu.add(i);
		}
		
		int cnt = 0;
		while(qu.size() > 1) {
			cnt++;
			if(cnt % k == 0) {
				qu.poll();
			} else {
				qu.offer(qu.poll());
			}
		}
		
		System.out.println(qu.peek());
	}

}
