package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * ��¥: 2021/11/06
 * ����: ������ DFSBFS 08-03 �ִ����� ���ϱ�(DFS)
 */

/*
 * �����Ѵ� ���Ѵ� ��� ���� Ȯ�� �� üũ �ϱ� ������ ��Ž DFS�̴�.
 * ���� �� DFS ������ ���������� �� ���� üũ�Ǿ� ȿ�����̳� �ߴµ� ū ���̴� ���°Ͱ���..
 * �׳� ��Ž�̸� ���ľ��ϰ� ������..
 */
class Exam implements Comparable<Exam>{
	int time; //�ɸ��� �ð�
	int score; //����
	
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
		
		//���ѽð� �ʰ��� ����
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
		N = sc.nextInt(); //��������
		M = sc.nextInt(); //���ѽð�
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
