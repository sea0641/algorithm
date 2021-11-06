package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 날짜: 2021/11/06
 * 문제: 인프런 DFSBFS 08-03 최대점수 구하기(DFS)
 */

/*
 * 포함한다 안한다 모든 원소 확인 후 체크 하기 때문에 완탐 DFS이다.
 * 정렬 후 DFS 돌리면 종료조건이 더 빨리 체크되어 효율적이나 했는데 큰 차이는 없는것같다..
 * 그냥 완탐이면 정렬안하고 돌리자..
 */
class Exam implements Comparable<Exam>{
	int time; //걸리는 시간
	int score; //점수
	
	Exam(int score, int time) {
		this.time = time;
		this.score = score;
	}
	
	@Override
	public int compareTo(Exam ex) {
		if(this.score == ex.score) return this.time - ex.time;
		else return ex.score - this.score;
	}
}

public class DfsBfs_08_03_2nd {
	static int M,N;
	static List<Exam> list;
	static int answer = 0;
	
	static void DFS(int L, int score, int time) {
		
		//제한시간 초과시 리턴
		if(M < time) return;
		
		if( L == N ) {
			answer = Math.max(score, answer);
		} else {
			Exam ex = list.get(L);
			DFS(L+1, score + ex.score, time + ex.time);
			DFS(L+1, score, time);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); //문제개수
		M = sc.nextInt(); //제한시간
		list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			int s = sc.nextInt();
			int t = sc.nextInt();
			
			list.add(new Exam(s, t));
		}
		Collections.sort(list);
		
		DFS(0, 0, 0);
		
		System.out.println(answer);
	}

}
