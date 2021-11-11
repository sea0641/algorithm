package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 날짜: 2021/11/08
 * 문제: 인프런 그리디 09-02 회의실 배정
 */

/*
 * 끝나는 시간, 시작시간 오름차순 정렬
 * 회의 수 느는 기준: 앞선 회의 끝나는 시간 <= 현재 회의 시작시간
 */
class Conf implements Comparable<Conf>{
	int sT, eT;
	Conf(int sT, int eT) {
		this.sT = sT;
		this.eT = eT;
	}
	
	@Override
	public int compareTo(Conf o) {
		if(this.eT != o.eT) return this.eT - o.eT; //끝나는 시간 오름차순
		else return this.sT - o.sT; //끝나는 시간이 같으면 시작시간 오름차순
	}
}

public class Greedy_09_02_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Conf> list = new ArrayList<Conf>();
		for(int i=0; i<n; i++) {
			int sT = sc.nextInt();
			int eT = sc.nextInt();
			list.add(new Conf(sT, eT));
		}
		
		Collections.sort(list);
		
		int answer = 0;
		int eT = 0;
		for(Conf c : list) {
			//회의 수 증가
			if(c.sT >= eT) {
				answer++;
				//해당 회의 끝나는 시간 변경
				eT = c.eT;
			}
		}
		
		System.out.println(answer);
	}

}
