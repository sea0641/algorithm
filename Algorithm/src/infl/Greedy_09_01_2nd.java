package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * ��¥: 2021/11/08
 * ����: ������ �׸��� 09-01 ���� ����
 */
class Body implements Comparable<Body> {
	public int h, w;
	Body(int h, int w) {
		this.h = h;
		this.w = w;
	}
	
	public int compareTo(Body o) {
		return o.h - this.h; //Ű ��������
	};
}

/*
 * Ű ���������Ͽ�, for���� ���� Ű�� ������ �ش� Ű������ �ִ� �����Ժ��� ���� ������ ������ �ȴ�.
 * ������ �ִ밪 ���ŵ� ������ count
 */
public class Greedy_09_01_2nd {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //�ο� ��
		
		List<Body> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			list.add(new Body(h, w));
		}
		Collections.sort(list);
		
		int answer = 0;
		int maxWg = Integer.MIN_VALUE;
		for(Body b : list) {
			if(maxWg < b.w) {
				answer++;
				maxWg = b.w;
			}
		}
		
		System.out.println(answer);
	}

}
