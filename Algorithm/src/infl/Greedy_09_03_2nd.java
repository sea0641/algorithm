package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * ��¥: 2021/11/10
 * ����: ������ �׸��� 09-03 ��ȥ��
 */

/*
 * ���� ��, ���� �� �и��Ͽ� ���ö����� ī��Ʈ +1, ������ -1�Ͽ� �ִ� ī��Ʈ ���
 */
class Time implements Comparable<Time>{
	public int time;
	public char state; //���ö�:s, ������:e
	
	Time(int time, char state) {
		this.time = time;
		this.state = state;
	}
	
	@Override
	public int compareTo(Time o) {
		//�ð� ��������, �ð� ������ ���� ��������
		if(this.time == o.time) return this.state - o.state;
		else return this.time - o.time;
	}
}

public class Greedy_09_03_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //�ο� ��
		
		List<Time> list = new ArrayList<Time>();
		for(int i=0; i<N; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			list.add(new Time(s,'s'));
			list.add(new Time(e,'e'));
		}
		
		Collections.sort(list);
		
		int cnt = 0; //��� �� ī����
		int maxCnt = Integer.MIN_VALUE;
		for(Time t : list) {
			if(t.state == 's') cnt++;
			else cnt--;
			
			maxCnt = Math.max(maxCnt, cnt);
		}
		
		System.out.println(maxCnt);
	}

}
