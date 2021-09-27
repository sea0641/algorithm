package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 날짜: 2021/08/23
 * 문제: 인프런 그리디 09-02 회의실 배정
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
public class Greedy_09_02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Conf> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int sT = sc.nextInt();
			int eT = sc.nextInt();
			arr.add(new Conf(sT, eT));
		}
		Collections.sort(arr);
		
		int answer = 0;
		int end = 0;
		for(Conf c : arr) {
			if(end <= c.sT) {
				answer++;
				end = c.eT;
			}
		}
		
		System.out.println(answer);
	}

}
