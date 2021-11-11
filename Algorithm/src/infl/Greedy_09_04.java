package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * ��¥: 2021/09/01
 * ����: ������ �׸��� 09-04 �ִ� ���� ������(PriorityQueue ���빮��)
 */

//class Lecture implements Comparable<Lecture>{
//	int money;
//	int time;
//	
//	Lecture(int money, int time) {
//		this.money = money;
//		this.time = time;
//	}
//	
//	@Override
//	public int compareTo(Lecture o) {
//		return o.time - this.time; //���� ��������
//	}
//}
public class Greedy_09_04 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		List<Lecture> list = new ArrayList<Lecture>();
		int max = Integer.MIN_VALUE; //�ִ� ��¥
		for(int i=0; i<n; i++) {
			int pay = sc.nextInt();
			int day = sc.nextInt();
			list.add(new Lecture(pay, day));
			if(day > max) max = day;
		}
		Collections.sort(list);
		
		int answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int j=0;
		for(int i=max; i>=1; i--) {
			for( ; j<n; j++) {
				if(list.get(j).time < i) break;
				pq.offer(list.get(j).money);
			}
			
			if(!pq.isEmpty()) answer += pq.poll(); //i������ ���������� �ִ�ݾ�
		}
		
		System.out.println(answer);
	}

}
