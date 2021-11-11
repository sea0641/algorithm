package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * ��¥: 2021/11/10
 * ����: ������ �׸��� 09-04 �ִ� ���� ������(PriorityQueue ���빮��)
 */

/*
 * ���� ��� ���ǰ� �켱����..
 * 1. ���Ǹ� ���� ������������ ������ ����
 * 2. �켱���� ť�� �ش� ���ڿ� ������ ���ǵ��� ��� ���ǿ켱������ �̴´�.
 */

class Lecture implements Comparable<Lecture>{
	int money;
	int time;
	
	Lecture(int money, int time) {
		this.money = money;
		this.time = time;
	}
	
	@Override
	public int compareTo(Lecture o) {
		return o.time - this.time; //���� ��������
	}
}

public class Greedy_09_04_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //���� ��
		List<Lecture> list = new ArrayList<Lecture>();
		int maxDay = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			int m = sc.nextInt();
			int t = sc.nextInt();
			
			list.add(new Lecture(m, t));
			
			maxDay = Math.max(maxDay, t);
		}
		Collections.sort(list);
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int answer = 0;
		int j = 0;
		for(int i=maxDay; i>0; i--) {
			for( ; j<N; j++) {
				//i������ ������ ���ǵ鸸 ť�� �ִ´�.
				if(list.get(j).time < i) break;
				pq.offer(list.get(j).money);
			}
			
			if(!pq.isEmpty()) answer += pq.poll();
		}
		
		System.out.println(answer);
	}

}
