package infl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * ��¥: 2021/08/23
 * ����: ������ �׸��� 09-01 ���� ����
 */

class Body implements Comparable<Body> {
	public int h, w;
	Body(int h, int w) {
		this.h = h;
		this.w = w;
	}
	
	public int compareTo(Body o) {
		return o.h - this.h; //��������
	};
}

public class Greedy_09_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Body> arr = new ArrayList<Body>();
		for(int i=0; i<n; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			arr.add(new Body(h, w));
		}
		
		int answer = 0;
		Collections.sort(arr); //Ű ��������
		int max = Integer.MIN_VALUE;
		//�ð����⵵: O(n)
		for(Body ob : arr) {
			if(ob.w > max) { // ������ Ŀ������ ī��Ʈ
				max = ob.w;
				answer++;
			}
		}
		
		
		System.out.println(answer);
	}

}
